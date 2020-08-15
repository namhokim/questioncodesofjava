package com.naver.cafe.thisisjava.wave1033513;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;

public class JVMSimulator extends java.applet.Applet implements Runnable {
    // Vars for the three outer panels that are contained inside the Applet's panel.
    // twoParts contains the stack and the method area. simulationController
    // contains the Step and Reset buttons and the hint label.
    private ThreeParts threeParts;
    private RegisterPanel registers;
    private ControlPanel simulationController;

    // Local reference to buttons on control panel allows for easy enabling and
    // disabling of buttons.
    private Button stepButton;
    private Button resetButton;
    private Button runButton;
    private Button stopButton;

    // If the "run" button is pushed, a separate thread will be invoked that
    // will cause the JVM to execute until the "stop" button is pressed.
    private Thread runner;
    private final int millisecondDelayBetweenSteps = 250;

    // Vars that implement the Java stack
    private final int stackBase = 0x33330000;
    private StackMemorySection stackMemorySection = new StackMemorySection(stackBase, SimData.stackMemorySectionSize);
    private StackMemoryView stackMemoryView;

    // Vars that implement the method area of the JVM
    private final int methodAreaBase = 0x44440000;
    private MemorySection methodAreaMemorySection = new MemorySection(methodAreaBase,
            SimData.methodAreaMemorySectionSize);
    private MemoryView methodAreaMemoryView;

    // Vars that implement the Java registers
    private int pcRegister;
    private int optopRegister;
    private int frameRegister;
    private int varsRegister;

    @Override
    public void init() {

        setBackground(SimData.appletBackgroundColor);
        setLayout(new BorderLayout(5, 5));

        threeParts = new ThreeParts(SimData.methodAreaMemorySectionSize);
        simulationController = new ControlPanel();
        stepButton = simulationController.getStepButton();
        resetButton = simulationController.getResetButton();
        runButton = simulationController.getRunButton();
        stopButton = simulationController.getStopButton();

        ColoredLabel title = new ColoredLabel(SimData.appletTitle, Label.CENTER, SimData.titleColor);
        title.setFont(new Font("Helvetica", Font.BOLD, 12));
        add("North", title);
        add("South", simulationController);
        add("Center", threeParts);

        // Get a reference to the UI objects that are actually manipulated by
        // the handlers of the Step and Reset buttons. These aren't available
        // without this explicit get() because these objects are buried several
        // levels down in embedded panels.
        stackMemoryView = threeParts.getStackMemoryViewReference();
        methodAreaMemoryView = threeParts.getMethodAreaMemoryViewReference();
        registers = threeParts.getRegisterPanel();

        // Place the bytecodes into the method area
        for (int i = 0; i < SimData.methodAreaMemorySectionSize; ++i) {

            methodAreaMemorySection.setAtAddress(methodAreaBase + i,
                    SimData.theProgram[i]);

            methodAreaMemorySection.setLogicalValueAtAddress(methodAreaBase + i,
                    SimData.byteCodeMnemonics[i]);
        }

        ResetState();
        UpdateStateDisplay();
    }

    @Override
    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Button) {
            String bname = (String) arg;
            if (bname.equals(StringTable.reset)) {

                stopButton.disable();
                runButton.enable();
                stepButton.enable();
                resetButton.disable();
                ResetState();
                UpdateStateDisplay();
            }
            else if (bname.equals(StringTable.step)) {

                resetButton.enable();
                ExecuteNextInstruction();
                UpdateStateDisplay();
            }
            else if (bname.equals(StringTable.run)) {

                stopButton.enable();
                runButton.disable();
                stepButton.disable();
                resetButton.disable();
                if (runner == null) {
                    runner = new Thread(this);
                    runner.start();
                }
            }
            else if (bname.equals(StringTable.stop)) {

                runButton.enable();
                stepButton.enable();
                resetButton.enable();
                stopButton.disable();
                if (runner != null) {
                    runner.stop();
                    runner = null;
                }
            }
        }
        return true;
    }

    // ExecuteNextInstruction() grabs the instruction pointed to by the program
    // counter, decodes it via the switch statement, and executes it by running the
    // code under the appropriate case statement. The program counter is always
    // set to the next instruction that should be executed, naturally. Only those
    // bytecodes that appear in the short sequence presented in this simulation
    // are interpreted here to save time (your time in downloading and my time
    // in writing.)
    void ExecuteNextInstruction() {

        int a, b, result, i, operand0, operand1, operand2, offset;
        float fa, fb, fresult;
        Float f;

        int nextOpCode = methodAreaMemorySection.getAtAddress(pcRegister);

        switch (nextOpCode) {

            case OpCode.AALOAD:
                executeAaload();
                break;

            case OpCode.ALOAD_0:
                executeAload_n(0);
                break;

            case OpCode.ASTORE_0:
                executeAstore_n(0);
                break;

            case OpCode.BIPUSH:
                operand0 = methodAreaMemorySection.getAtAddress(pcRegister + 1);
                stackMemorySection.setAtAddress(optopRegister, operand0);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(operand0));
                optopRegister += 4;
                pcRegister += 2;
                break;

            // The BREAKPOINT opcode will serve as a stop sign for a running simulation.
            case OpCode.BREAKPOINT:
                stopButton.disable();
                runButton.disable();
                stepButton.disable();
                resetButton.enable();
                if (runner != null) {
                    // If runner is not null, then this is probably the thread that
                    // we want to stop. Therefore, as soon as stop has been executed,
                    // nothing else will happen. So we must set runner to null before
                    // we call runner.stop(). Therefore I copy runner to temp, assign
                    // null to runner, and call stop() on temp.
                    Thread temp = runner;
                    runner = null;
                    temp.stop();
                }
                break;

            case OpCode.FCONST_0:
                stackMemorySection.setAtAddress(optopRegister, Float.floatToIntBits((float) 0));
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "0");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.FCONST_2:
                stackMemorySection.setAtAddress(optopRegister, Float.floatToIntBits((float) 2));
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "2");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.FLOAD_0:
                a = stackMemorySection.getAtAddress(varsRegister);
                stackMemorySection.setAtAddress(optopRegister, a);
                fa = Float.intBitsToFloat(a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Float.toString(fa));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.FMUL:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                fa = Float.intBitsToFloat(a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                fb = Float.intBitsToFloat(b);
                fresult = fa * fb;
                result = Float.floatToIntBits(fresult);
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Float.toString(fresult));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.FSTORE_0:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                stackMemorySection.setAtAddress(varsRegister, a);
                fa = Float.intBitsToFloat(a);
                stackMemorySection.setLogicalValueAtAddress(varsRegister, Float.toString(fa));
                ++pcRegister;
                break;

            case OpCode.FSUB:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                fa = Float.intBitsToFloat(a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                fb = Float.intBitsToFloat(b);
                fresult = fb - fa;
                result = Float.floatToIntBits(fresult);
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Float.toString(fresult));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.GOTO:
                operand1 = methodAreaMemorySection.getAtAddress(pcRegister + 1);
                operand0 = methodAreaMemorySection.getAtAddress(pcRegister + 2);

                offset = (operand1 << 8) | (operand0 & 0xff);

                pcRegister += offset;
                break;

            case OpCode.IADD:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                result = a + b;
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(result));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.IAND:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                result = a & b;
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(result));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.IASTORE:
                executeIastore();
                break;

            case OpCode.ICONST_M1:
                stackMemorySection.setAtAddress(optopRegister, -1);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "-1");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ICONST_0:
                stackMemorySection.setAtAddress(optopRegister, 0);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "0");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ICONST_1:
                stackMemorySection.setAtAddress(optopRegister, 1);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "1");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ICONST_2:
                stackMemorySection.setAtAddress(optopRegister, 2);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "2");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ICONST_3:
                stackMemorySection.setAtAddress(optopRegister, 3);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "3");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ICONST_4:
                stackMemorySection.setAtAddress(optopRegister, 4);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "4");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ICONST_5:
                stackMemorySection.setAtAddress(optopRegister, 5);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "5");
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.IFNE:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                // If a != 0 jump, else go on
                if (a != 0) {
                    operand1 = methodAreaMemorySection.getAtAddress(pcRegister + 1);
                    operand0 = methodAreaMemorySection.getAtAddress(pcRegister + 2);
                    offset = (operand1 << 8) | (operand0 & 0xff);
                    pcRegister += offset;
                }
                else {
                    pcRegister += 3;
                }
                break;

            case OpCode.IF_ICMPLT:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                // If b < a jump, else go on
                if (b < a) {
                    operand1 = methodAreaMemorySection.getAtAddress(pcRegister + 1);
                    operand0 = methodAreaMemorySection.getAtAddress(pcRegister + 2);
                    offset = (operand1 << 8) | (operand0 & 0xff);
                    pcRegister += offset;
                }
                else {
                    pcRegister += 3;
                }
                break;

            case OpCode.IINC:
                operand0 = methodAreaMemorySection.getAtAddress(pcRegister + 1);
                operand1 = methodAreaMemorySection.getAtAddress(pcRegister + 2);
                a = stackMemorySection.getAtAddress(varsRegister + (operand0 * 4));
                a += operand1;
                stackMemorySection.setAtAddress(varsRegister + (operand0 * 4), a);
                stackMemorySection.setLogicalValueAtAddress(varsRegister + (operand0 * 4), Integer.toString(a));
                pcRegister += 3;
                break;

            case OpCode.ILOAD_0:
                a = stackMemorySection.getAtAddress(varsRegister);
                stackMemorySection.setAtAddress(optopRegister, a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(a));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ILOAD_1:
                a = stackMemorySection.getAtAddress(varsRegister + 4);
                stackMemorySection.setAtAddress(optopRegister, a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(a));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ILOAD_2:
                a = stackMemorySection.getAtAddress(varsRegister + 8);
                stackMemorySection.setAtAddress(optopRegister, a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(a));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ILOAD_3:
                a = stackMemorySection.getAtAddress(varsRegister + 12);
                stackMemorySection.setAtAddress(optopRegister, a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(a));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.IMUL:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                result = a * b;
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(result));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.INT2BYTE:
                a = stackMemorySection.getAtAddress(optopRegister - 4);
                a = (byte) a;
                stackMemorySection.setAtAddress(optopRegister - 4, a);
                stackMemorySection.setLogicalValueAtAddress(optopRegister - 4, Integer.toString(a));
                ++pcRegister;
                break;

            case OpCode.IOR:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                result = a | b;
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(result));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ISHL:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                result = b << (a & 0x1f);
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(result));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.ISTORE_0:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                stackMemorySection.setAtAddress(varsRegister, a);
                stackMemorySection.setLogicalValueAtAddress(varsRegister, Integer.toString(a));
                ++pcRegister;
                break;

            case OpCode.ISTORE_1:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                stackMemorySection.setAtAddress(varsRegister + 4, a);
                stackMemorySection.setLogicalValueAtAddress(varsRegister + 4, Integer.toString(a));
                ++pcRegister;
                break;

            case OpCode.ISTORE_2:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                stackMemorySection.setAtAddress(varsRegister + 8, a);
                stackMemorySection.setLogicalValueAtAddress(varsRegister + 8, Integer.toString(a));
                ++pcRegister;
                break;

            case OpCode.ISTORE_3:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                stackMemorySection.setAtAddress(varsRegister + 12, a);
                stackMemorySection.setLogicalValueAtAddress(varsRegister + 12, Integer.toString(a));
                ++pcRegister;
                break;

            case OpCode.IXOR:
                optopRegister -= 4;
                a = stackMemorySection.getAtAddress(optopRegister);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
                optopRegister -= 4;
                b = stackMemorySection.getAtAddress(optopRegister);
                result = a ^ b;
                stackMemorySection.setAtAddress(optopRegister, result);
                stackMemorySection.setLogicalValueAtAddress(optopRegister, Integer.toString(result));
                optopRegister += 4;
                ++pcRegister;
                break;

            case OpCode.MULTIANEWARRAY:
                executeMultianewarray();
                pcRegister += 4;
                break;
        }
    }

    // Pushing the Reset button will cause ResetState() to be executed, which will
    // reset all the data to its initial values.
    void ResetState() {

        pcRegister = methodAreaBase;
        optopRegister = stackBase + SimData.optopOffset;
        frameRegister = stackBase + SimData.frameOffset;
        varsRegister = stackBase;

        int i;
        for (i = 0; i < SimData.stackMemorySectionSize; ++i) {
            stackMemorySection.setLogicalValueAtAddress(stackBase + (i * 4), "");
            stackMemorySection.setAtAddress(stackBase + (i * 4), 0);
        }
        methodAreaMemoryView.update(methodAreaMemorySection, methodAreaBase);
    }

    // UpdateStateDisplay writes the current state of the JVM to the UI.
    void UpdateStateDisplay() {

        registers.setPcRegister(pcRegister);
        registers.setOptopRegister(optopRegister);
        registers.setFrameRegister(frameRegister);
        registers.setVarsRegister(varsRegister);

        stackMemoryView.update(stackMemorySection, stackBase);

        methodAreaMemoryView.updateProgramCounter(pcRegister - methodAreaBase, methodAreaMemorySection);

        stackMemoryView.clearPointers();
        stackMemoryView.updatePointer((varsRegister - stackBase) / 4, StringTable.varsPointer);
        stackMemoryView.updatePointer((frameRegister - stackBase) / 4, StringTable.framePointer);
        stackMemoryView.updatePointer((optopRegister - stackBase) / 4, StringTable.optopPointer);

        int nextOpCode = methodAreaMemorySection.getAtAddress(pcRegister);

        switch (nextOpCode) {

            case OpCode.AALOAD:
                simulationController.setExplanationText(StringTable.aaloadText);
                break;

            case OpCode.ALOAD_0:
                simulationController.setExplanationText(StringTable.aload_0Text);
                break;

            case OpCode.ASTORE_0:
                simulationController.setExplanationText(StringTable.astore_0Text);
                break;

            case OpCode.BIPUSH:
                simulationController.setExplanationText(StringTable.bipushText);
                break;

            case OpCode.BREAKPOINT:
                simulationController.setExplanationText(StringTable.breakpointText);
                break;

            case OpCode.FCONST_0:
                simulationController.setExplanationText(StringTable.fconst_0Text);
                break;

            case OpCode.FCONST_2:
                simulationController.setExplanationText(StringTable.fconst_2Text);
                break;

            case OpCode.FLOAD_0:
                simulationController.setExplanationText(StringTable.fload_0Text);
                break;

            case OpCode.FMUL:
                simulationController.setExplanationText(StringTable.fmulText);
                break;

            case OpCode.FSTORE_0:
                simulationController.setExplanationText(StringTable.fstore_0Text);
                break;

            case OpCode.FSUB:
                simulationController.setExplanationText(StringTable.fsubText);
                break;

            case OpCode.GOTO:
                simulationController.setExplanationText(StringTable.gotoText);
                break;

            case OpCode.IADD:
                simulationController.setExplanationText(StringTable.iaddText);
                break;

            case OpCode.IAND:
                simulationController.setExplanationText(StringTable.iandText);
                break;

            case OpCode.IASTORE:
                simulationController.setExplanationText(StringTable.iastoreText);
                break;

            case OpCode.ICONST_M1:
                simulationController.setExplanationText(StringTable.iconst_m1Text);
                break;

            case OpCode.ICONST_0:
                simulationController.setExplanationText(StringTable.iconst_0Text);
                break;

            case OpCode.ICONST_1:
                simulationController.setExplanationText(StringTable.iconst_1Text);
                break;

            case OpCode.ICONST_2:
                simulationController.setExplanationText(StringTable.iconst_2Text);
                break;

            case OpCode.ICONST_3:
                simulationController.setExplanationText(StringTable.iconst_3Text);
                break;

            case OpCode.ICONST_4:
                simulationController.setExplanationText(StringTable.iconst_4Text);
                break;

            case OpCode.ICONST_5:
                simulationController.setExplanationText(StringTable.iconst_5Text);
                break;

            case OpCode.IF_ICMPLT:
                simulationController.setExplanationText(StringTable.if_icmpltText);
                break;

            case OpCode.IFNE:
                simulationController.setExplanationText(StringTable.ifneText);
                break;

            case OpCode.IINC:
                simulationController.setExplanationText(StringTable.iincText);
                break;

            case OpCode.ILOAD_0:
                simulationController.setExplanationText(StringTable.iload_0Text);
                break;

            case OpCode.ILOAD_1:
                simulationController.setExplanationText(StringTable.iload_1Text);
                break;

            case OpCode.ILOAD_2:
                simulationController.setExplanationText(StringTable.iload_2Text);
                break;

            case OpCode.ILOAD_3:
                simulationController.setExplanationText(StringTable.iload_3Text);
                break;

            case OpCode.IMUL:
                simulationController.setExplanationText(StringTable.imulText);
                break;

            case OpCode.INT2BYTE:
                simulationController.setExplanationText(StringTable.int2byteText);
                break;

            case OpCode.IOR:
                simulationController.setExplanationText(StringTable.iorText);
                break;

            case OpCode.ISHL:
                simulationController.setExplanationText(StringTable.ishlText);
                break;

            case OpCode.ISTORE_0:
                simulationController.setExplanationText(StringTable.istore_0Text);
                break;

            case OpCode.ISTORE_1:
                simulationController.setExplanationText(StringTable.istore_1Text);
                break;

            case OpCode.ISTORE_2:
                simulationController.setExplanationText(StringTable.istore_2Text);
                break;

            case OpCode.ISTORE_3:
                simulationController.setExplanationText(StringTable.istore_3Text);
                break;

            case OpCode.IXOR:
                simulationController.setExplanationText(StringTable.ixorText);
                break;

            case OpCode.MULTIANEWARRAY:
                simulationController.setExplanationText(StringTable.multianewarrayText);
                break;

            default:
                simulationController.setExplanationText("");
                break;
        }
    }

    // Make pretty border around entire applet panel
    public Insets insets() {
        return new Insets(5, 5, 5, 5);
    }

    @Override
    public void stop() {
        if (runner != null) {
            runner.stop();
            runner = null;
        }
    }

    @Override
    public void run() {
        while (true) {
            ExecuteNextInstruction();
            UpdateStateDisplay();
            try {
                Thread.sleep(millisecondDelayBetweenSteps);
            }
            catch (InterruptedException e) {
            }
        }
    }


    void executeAaload() {

        // Pop array index.
        optopRegister -= 4;
        int index = stackMemorySection.getAtAddress(optopRegister);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, "");

        // Pop reference to array of object references.
        // Cast generic object reference to a reference to an array of objects. This
        // will cause the JVM to do a checkcast instruction to make sure this is a
        // valid operation. An exception will be thrown if I've got any other kind
        // of array or object reference. Once this succeeds, I can use the arrayRef
        // as an array to get the index'th object reference and push it.
        optopRegister -= 4;
        Object objRef = stackMemorySection.getObjectAtAddress(optopRegister);
        Object[] arrayRef = (Object[]) objRef;

        // Push the object reference at arrayRef[index].
        stackMemorySection.setObjectAtAddress(optopRegister, arrayRef[index]);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, StringTable.objectReference);
        optopRegister += 4;
        ++pcRegister;
    }

    void executeAload_n(int locVar) {

        Object objRef = stackMemorySection.getObjectAtAddress(varsRegister + (4 * locVar));
        stackMemorySection.setObjectAtAddress(optopRegister, objRef);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, StringTable.objectReference);
        optopRegister += 4;
        ++pcRegister;
    }

    void executeAstore_n(int locVar) {

        optopRegister -= 4;
        Object objRef = stackMemorySection.getObjectAtAddress(optopRegister);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
        stackMemorySection.setObjectAtAddress(varsRegister + (4 * locVar), objRef);
        stackMemorySection.setLogicalValueAtAddress(varsRegister + (4 * locVar), StringTable.objectReference);
        ++pcRegister;
    }

    void executeIastore() {

        // Pop int value.
        optopRegister -= 4;
        int value = stackMemorySection.getAtAddress(optopRegister);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, "");

        // Pop index.
        optopRegister -= 4;
        int index = stackMemorySection.getAtAddress(optopRegister);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, "");

        // Pop reference to an array of integers. Must cast the generic object
        // reference to a reference to an array of integers, then use that
        // to assign arrayRef[index] = value.
        optopRegister -= 4;
        Object objRef = stackMemorySection.getObjectAtAddress(optopRegister);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
        int[] arrayRef = (int[]) objRef;

        arrayRef[index] = value;
        ++pcRegister;
    }

    void executeMultianewarray() {

        int indexbyte1 = methodAreaMemorySection.getAtAddress(pcRegister + 1);
        int indexbyte0 = methodAreaMemorySection.getAtAddress(pcRegister + 2);
        int dim = methodAreaMemorySection.getAtAddress(pcRegister + 3);
        if (dim < 1) {
            // this is an exception
            return;
        }
        // Fill an array with the sizes of the various arrays. The sizes go into the
        // array in the order in which they appear in the declaration, left to right.
        // This was the same order in which they were pushed onto the stack. Therefore,
        // the first element is assigned the value most buried (furthest down) in the
        // stack.
        int[] size = new int[dim];
        for (int i = dim - 1; i >= 0; --i) {
            optopRegister -= 4;
            size[i] = stackMemorySection.getAtAddress(optopRegister);
            stackMemorySection.setLogicalValueAtAddress(optopRegister, "");
        }

        // This time around, I'll just assume it's an array of ints. In the future, I'll
        // need to check the constant pool and pass down the type.
        Object result = createMultiDimArray(size);

        stackMemorySection.setObjectAtAddress(optopRegister, result);
        stackMemorySection.setLogicalValueAtAddress(optopRegister, StringTable.objectReference);
        optopRegister += 4;
    }

    Object createMultiDimArray(int[] size) {
        Object result;
        if (size.length == 1) {
            result = new int[size[0]];
        }
        else {

            // Create and initialize an array of arrays
            Object[] arrayOfArrays = new Object[size[0]];
            result = arrayOfArrays;

            // As soon as a size of zero is hit for the next array, we are done. This
            // will be the case if some of the square brackets were left empty in
            // the declaration, as in "new int[5][4][][]," in which the third and fourth
            // sizes will be zero.
            if (size[1] != 0) {
                // Create and initialize an array of sizes to be passed to a recursive call
                // to createMultiDimArray(). This array is identical to the array passed
                // to this function with the first element clipped off.
                int[] nextSize = new int[size.length - 1];
                for (int i = 1; i < size.length; ++i) {
                    nextSize[i - 1] = size[i];
                }

                // Call this function recursively to create initialize this array
                // of array with the sub-arrays.
                for (int i = 0; i < size[0]; ++i) {
                    arrayOfArrays[i] = createMultiDimArray(nextSize);
                }
            }
        }
        return result;
    }
}

// I used this class because I can't seem to set the background color of
// a label.  I only want a label, but I want the backgound to be gray.
class ColoredLabel extends Panel {

    private Label theLabel;

    ColoredLabel(String label, int alignment, Color color) {

        setLayout(new GridLayout(1,1));

        setBackground(color);

        theLabel = new Label(label, alignment);

        add(theLabel);
    }

    public void setLabelText(String s) {

        theLabel.setText(s);
    }

    public Insets insets() {
        return new Insets(0, 0, 0, 0);
    }
}

class ControlPanel extends Panel {

    private ColoredLabel explanationLabel;
    private GrayButton stepButton = new GrayButton(StringTable.step);
    private GrayButton resetButton = new GrayButton(StringTable.reset);
    private GrayButton runButton = new GrayButton(StringTable.run);
    private GrayButton stopButton = new GrayButton(StringTable.stop);

    ControlPanel() {

        setLayout(new BorderLayout(5, 5));

        Panel leftButtonPanel = new Panel();
        leftButtonPanel.setLayout(new GridLayout(2,2,5,5));
        leftButtonPanel.add(stepButton);
        resetButton.disable();
        leftButtonPanel.add(runButton);
        leftButtonPanel.add(resetButton);
        leftButtonPanel.add(stopButton);
        stopButton.disable();
        explanationLabel = new ColoredLabel("This is where the explanation goes...",
                Label.CENTER, Color.lightGray);

        explanationLabel.setBackground(SimData.explanationLabel);
        Font plainFont = new Font("TimesRoman", Font.ITALIC, 12);
        explanationLabel.setFont(plainFont);

        add("West", leftButtonPanel);
        add("Center", explanationLabel);
    }

    public void setExplanationText(String explanation) {

        explanationLabel.setLabelText(explanation);
    }

    public Button getStepButton() {
        return stepButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public Button getRunButton() {
        return runButton;
    }

    public Button getStopButton() {
        return stopButton;
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class GrayButton extends Button {

    GrayButton(String label) {

        super(label);
        setBackground(Color.lightGray);
    }
}

// GridSnapLayout lays out components in a grid that can have columns of
// varying width. This is not a very general purpose layout manager. It
// solves the specific problem of getting all the information I want to display about
// the stack and method areas in a nice grid. Because some columns of info need
// more room than others, and space is limited on a web page, I needed to be
// able to specify varying widths of columns in a grid.
class GridSnapLayout implements LayoutManager {

    // rows and cols are the number of rows and columns of the grid upon
    // which the components are placed. Components are always one row
    // in height, but may be more than one column in width. The number
    // of columns width of each component is stored in hComponentCellWidths.
    // The array length of hComponentCellWidths indicates the number of
    // components that will appear on each row.
    private int rows;
    private int cols;
    private int[] hComponentCellWidths;

    public GridSnapLayout(int rows, int cols, int[] hComponentCellWidths) {

        this.rows = rows;
        this.cols = cols;
        this.hComponentCellWidths = hComponentCellWidths;
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    // Calculate preferred size as if each component were taking an equal
    // share of the width of a row.
    public Dimension preferredLayoutSize(Container parent) {

        int rowCount = rows;
        int colCount = cols;
        Insets parentInsets = parent.insets();
        int componentCount = parent.countComponents();

        if (rowCount > 0) {
            colCount = (componentCount + rowCount - 1) / rowCount;
        } else {
            rowCount = (componentCount + colCount - 1) / colCount;
        }

        // Find the maximum preferred width and the maximum preferred height
        // of any component.
        int w = 0;
        int h = 0;
        for (int i = 0; i < componentCount; i++) {

            Component comp = parent.getComponent(i);
            Dimension d = comp.preferredSize();
            if (w < d.width) {
                w = d.width;
            }
            if (h < d.height) {
                h = d.height;
            }
        }

        // Return the maximum preferred component width and height times the number
        // of columns and rows, respectively, plus any insets in the parent.
        return new Dimension(parentInsets.left + parentInsets.right + colCount*w,
                parentInsets.top + parentInsets.bottom + rowCount*h);
    }

    // Calculate minimum size as if each component were taking an equal
    // share of the width of a row.
    public Dimension minimumLayoutSize(Container parent) {

        Insets parentInsets = parent.insets();
        int componentCount = parent.countComponents();
        int rowCount = rows;
        int colCount = cols;

        if (rowCount > 0) {
            colCount = (componentCount + rowCount - 1) / rowCount;
        } else {
            rowCount = (componentCount + colCount - 1) / colCount;
        }

        // Find the maximum "minimum width" and the maximum "minimum height"
        // of any component.
        int w = 0;
        int h = 0;
        for (int i = 0; i < componentCount; i++) {

            Component comp = parent.getComponent(i);
            Dimension d = comp.minimumSize();
            if (w < d.width) {
                w = d.width;
            }
            if (h < d.height) {
                h = d.height;
            }
        }

        // Return the maximum "minimum component width and height" times the number
        // of columns and rows, respectively, plus any insets in the parent.
        return new Dimension(parentInsets.left + parentInsets.right + colCount*w,
                parentInsets.top + parentInsets.bottom + rowCount*h);
    }

    // Layout the container such that the widths of columns correspond
    // to the number of columns in that components hComponentCellWidth
    // array element. For example, if the
    public void layoutContainer(Container parent) {

        int rowCount = rows;
        int colCount = hComponentCellWidths.length;
        Insets parentInsets = parent.insets();
        int componentCount = parent.countComponents();

        if (componentCount == 0) {
            return;
        }

        // Calculate the width and height of each grid cell. The height will
        // be the height of each component, but the width may not. The width
        // of a component will be some multiple of a grid cell width. The
        // number of grid cells for each component is defined by the
        // hComponentCellWidths array. w is width of each grid cell. h is
        // height of each grid cell.
        Dimension parentDim = parent.size();
        int w = parentDim.width - (parentInsets.left + parentInsets.right);
        int h = parentDim.height - (parentInsets.top + parentInsets.bottom);
        w /= cols;
        h /= rowCount;

        // For each row and column of components (not grid cells) position
        // the component.
        for (int c = 0, x = parentInsets.left ; c < colCount ; c++) {
            for (int r = 0, y = parentInsets.top ; r < rowCount ; r++) {

                int i = r * colCount + c;
                if (i < componentCount) {
                    parent.getComponent(i).reshape(x, y, w * hComponentCellWidths[c], h);
                }
                y += h;
            }
            x += (w * hComponentCellWidths[c]);
        }
    }
}

class HexString {

    private final String hexChar = "0123456789abcdef";
    private StringBuffer buf = new StringBuffer();

    void Convert(int val, int maxNibblesToConvert) {

        buf.setLength(0);

        int v = val;
        for (int i = 0; i < maxNibblesToConvert; ++i) {

            if (v == 0) {

                if (i == 0) {
                    buf.insert(0, '0');
                }
                break;
            }

            // Get lowest nibble
            int remainder = v & 0xf;

            // Convert nibble to a character and insert it into the beginning of the string
            buf.insert(0, hexChar.charAt(remainder));

            // Shift the int to the right four bits
            v >>>= 4;
        }
    }

    HexString(int val, int minWidth) {

        Convert(val, minWidth);

        int charsNeeded = minWidth - buf.length();
        for (int i = 0; i < charsNeeded; ++i) {
            buf.insert(0, '0');
        }
    }

    public String getString() {

        return buf.toString();
    }
}

class LabeledRegister extends Panel {

    private ColoredLabel registerContents;

    LabeledRegister(String labelText) {

        setLayout(new BorderLayout(5,5));

        registerContents = new ColoredLabel("00000000", Label.CENTER, Color.lightGray);
        registerContents.setFont(new Font("TimesRoman", Font.PLAIN, 11));

        Label title = new Label(labelText, Label.RIGHT);
        title.setFont(new Font("Helvetica", Font.ITALIC, 11));

        add("East", registerContents);
        add("Center", title);
    }

    public void setRegister(int val) {

        HexString hexString = new HexString(val, 8);
        registerContents.setLabelText(hexString.getString());
    }

    public Insets insets() {
        return new Insets(0, 0, 0, 0);
    }
}


// MemorySection is just used for the method area in this applet. This implements
// the functionality of the method area and has nothing to do with the UI.
class MemorySection {

    private int[] memory;
    private int baseAddress;
    private String[] logicalValueString;

    MemorySection(int base, int size) {

        baseAddress = base;

        memory = new int[size];
        logicalValueString = new String[size];

        for (int i = 0; i < size; ++i) {

            logicalValueString[i] = new String();
        }
    }

    int getBaseAddress() {
        return baseAddress;
    }

    public int getAtAddress(int address) {

        return memory[address - baseAddress];
    }

    public String getLogicalValueAtAddress(int address) {

        return logicalValueString[address - baseAddress];
    }

    public void setAtAddress(int address, int value) {

        memory[address - baseAddress] = value;
    }

    public void setLogicalValueAtAddress(int address, String s) {

        logicalValueString[address - baseAddress] = s;
    }

    int getSize() {
        return memory.length;
    }
}

// MemoryView is just used for the method area in this applet.  It implements the
// UI of the method area.
class MemoryView extends Panel {

    private final int memoryLocationsVisibleCount = SimData.methodAreaMemoryLocationsVisibleCount;

    private Label[] pointer = new Label[memoryLocationsVisibleCount];
    private Label[] address = new Label[memoryLocationsVisibleCount];
    private Label[] byteValue = new Label[memoryLocationsVisibleCount];
    private Label[] logicalValue = new Label[memoryLocationsVisibleCount];

    private int firstVisibleRow;
    private int currentProgramCounterRow;

    MemoryView(int methodAreaMemSectionSize) {

        int[] hComponentCellWidths = new int[4];
        hComponentCellWidths[0] = 2;
        hComponentCellWidths[1] = 2;
        hComponentCellWidths[2] = 2;
        hComponentCellWidths[3] = 3;
        setLayout(new GridSnapLayout(memoryLocationsVisibleCount, 9, hComponentCellWidths));

        setBackground(Color.lightGray);
        Font plainFont = new Font("TimesRoman", Font.PLAIN, 11);
        setFont(plainFont);

        Font italicFont = new Font("TimesRoman", Font.ITALIC, 11);

        for (int i = 0; i < memoryLocationsVisibleCount; ++i) {

            pointer[i] = new Label("", Label.RIGHT);
            pointer[i].setFont(italicFont);
            add(pointer[i]);

            address[i] = new Label("", Label.CENTER);
            add(address[i]);

            byteValue[i] = new Label("", Label.CENTER);
            add(byteValue[i]);

            logicalValue[i] = new Label("", Label.LEFT);
            add(logicalValue[i]);
        }
    }

    public void setAt(int i, int addressValue, int value, String logicalValueStr) {

        HexString addressValueHexString = new HexString(addressValue, 8);
        HexString byteValueHexString = new HexString(value, 2);

        address[i].setText(addressValueHexString.getString());
        byteValue[i].setText(byteValueHexString.getString());
        logicalValue[i].setText(logicalValueStr);
    }

    public void update(MemorySection memorySection, int initialAddress){

        for (int i = 0; i < memoryLocationsVisibleCount; ++i) {

            int theByte = memorySection.getAtAddress(initialAddress + i);
            String logicalValue = memorySection.getLogicalValueAtAddress(
                    initialAddress + i);
            setAt(i, initialAddress + i, theByte, logicalValue);
        }
    }

    public void clearPointers() {

        for (int i = 0; i < memoryLocationsVisibleCount; ++i) {
            pointer[i].setText("");
        }
    }

    public void updateProgramCounter(int i, MemorySection memorySection) {

        pointer[currentProgramCounterRow - firstVisibleRow].setText("");

        if (i - firstVisibleRow >= memoryLocationsVisibleCount) {
            firstVisibleRow = i;
            if (firstVisibleRow > memorySection.getSize() - memoryLocationsVisibleCount) {
                firstVisibleRow = memorySection.getSize() - memoryLocationsVisibleCount;
            }
            update(memorySection, memorySection.getBaseAddress() + firstVisibleRow);
        }
        else if (i < firstVisibleRow) {
            firstVisibleRow = i;
            update(memorySection, memorySection.getBaseAddress() + firstVisibleRow);
        }

        pointer[i - firstVisibleRow].setText("pc >");
        currentProgramCounterRow = i;
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class MemoryViewTitlePanel extends Panel {

    MemoryViewTitlePanel () {

        int[] hComponentCellWidths = new int[4];
        hComponentCellWidths[0] = 2;
        hComponentCellWidths[1] = 2;
        hComponentCellWidths[2] = 2;
        hComponentCellWidths[3] = 3;
        setLayout(new GridSnapLayout(1, 9, hComponentCellWidths));

        setFont(new Font("Helvetica", Font.ITALIC, 11));

        add(new Label("", Label.CENTER));
        add(new Label(StringTable.address, Label.CENTER));
        add(new Label(StringTable.bytecodes, Label.CENTER));
        add(new Label(StringTable.mnemonics, Label.LEFT));
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class MemoryViewWithTitles extends Panel {

    private MemoryView memoryView;

    MemoryViewWithTitles(int methodAreaMemorySectionSize) {

        memoryView = new MemoryView(methodAreaMemorySectionSize);
        setLayout(new BorderLayout());

        add("North", new MemoryViewTitlePanel());
        add("Center", memoryView);
    }

    public MemoryView getMemoryViewReference(){

        return memoryView;
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class MethodAreaPanel extends Panel {

    private Label title;
    private MemoryViewWithTitles memoryView;

    MethodAreaPanel(int methodAreaMemorySectionSize) {

        memoryView = new MemoryViewWithTitles(methodAreaMemorySectionSize);
        setLayout(new BorderLayout());

        title = new Label("Method Area", Label.CENTER);
        title.setFont(new Font("Helvetica", Font.BOLD, 11));

        add("North", title);
        add("Center", memoryView);
    }

    public MemoryView getMemoryViewReference() {

        return memoryView.getMemoryViewReference();
    }

    public Insets insets() {
        return new Insets(5, 5, 5, 5);
    }
}


class OpCode {

    final static int NOP = 0;
    final static int ACONST_NULL = 1;
    final static int ICONST_M1 = 2;
    final static int ICONST_0 = 3;
    final static int ICONST_1 = 4;
    final static int ICONST_2 = 5;
    final static int ICONST_3 = 6;
    final static int ICONST_4 = 7;
    final static int ICONST_5 = 8;
    final static int LCONST_0 = 9;
    final static int LCONST_1 = 10;
    final static int FCONST_0 = 11;
    final static int FCONST_1 = 12;
    final static int FCONST_2 = 13;
    final static int DCONST_0 = 14;
    final static int DCONST_1 = 15;
    final static int BIPUSH = 16;
    final static int SIPUSH = 17;
    final static int LDC1 = 18;
    final static int LDC2 = 19;
    final static int LDC2W = 20;
    final static int ILOAD = 21;
    final static int LLOAD = 22;
    final static int FLOAD = 23;
    final static int DLOAD = 24;
    final static int ALOAD = 25;
    final static int ILOAD_0 = 26;
    final static int ILOAD_1 = 27;
    final static int ILOAD_2 = 28;
    final static int ILOAD_3 = 29;
    final static int LLOAD_0 = 30;
    final static int LLOAD_1 = 31;
    final static int LLOAD_2 = 32;
    final static int LLOAD_3 = 33;
    final static int FLOAD_0 = 34;
    final static int FLOAD_1 = 35;
    final static int FLOAD_2 = 36;
    final static int FLOAD_3 = 37;
    final static int DLOAD_0 = 38;
    final static int DLOAD_1 = 39;
    final static int DLOAD_2 = 40;
    final static int DLOAD_3 = 41;
    final static int ALOAD_0 = 42;
    final static int ALOAD_1 = 43;
    final static int ALOAD_2 = 44;
    final static int ALOAD_3 = 45;
    final static int IALOAD = 46;
    final static int LALOAD = 47;
    final static int FALOAD = 48;
    final static int DALOAD = 49;
    final static int AALOAD = 50;
    final static int BALOAD = 51;
    final static int CALOAD = 52;
    final static int SALOAD = 53;
    final static int ISTORE = 54;
    final static int LSTORE = 55;
    final static int FSTORE = 56;
    final static int DSTORE = 57;
    final static int ASTORE = 58;
    final static int ISTORE_0 = 59;
    final static int ISTORE_1 = 60;
    final static int ISTORE_2 = 61;
    final static int ISTORE_3 = 62;
    final static int LSTORE_0 = 63;
    final static int LSTORE_1 = 64;
    final static int LSTORE_2 = 65;
    final static int LSTORE_3 = 66;
    final static int FSTORE_0 = 67;
    final static int FSTORE_1 = 68;
    final static int FSTORE_2 = 69;
    final static int FSTORE_3 = 70;
    final static int DSTORE_0 = 71;
    final static int DSTORE_1 = 72;
    final static int DSTORE_2 = 73;
    final static int DSTORE_3 = 74;
    final static int ASTORE_0 = 75;
    final static int ASTORE_1 = 76;
    final static int ASTORE_2 = 77;
    final static int ASTORE_3 = 78;
    final static int IASTORE = 79;
    final static int LASTORE = 80;
    final static int FASTORE = 81;
    final static int DASTORE = 82;
    final static int AASTORE = 83;
    final static int BASTORE = 84;
    final static int CASTORE = 85;
    final static int SASTORE = 86;
    final static int POP = 87;
    final static int POP2 = 88;
    final static int DUP = 89;
    final static int DUP_X1 = 90;
    final static int DUP_X2 = 91;
    final static int DUP2 = 92;
    final static int DUP2_X1 = 93;
    final static int DUP2_X2 = 94;
    final static int SWAP = 95;
    final static int IADD = 96;
    final static int LADD = 97;
    final static int FADD = 98;
    final static int DADD = 99;
    final static int ISUB = 100;
    final static int LSUB = 101;
    final static int FSUB = 102;
    final static int DSUB = 103;
    final static int IMUL = 104;
    final static int LMUL = 105;
    final static int FMUL = 106;
    final static int DMUL = 107;
    final static int IDIV = 108;
    final static int LDIV = 109;
    final static int FDIV = 110;
    final static int DDIV = 111;
    final static int IREM = 112;
    final static int LREM = 113;
    final static int FREM = 114;
    final static int DREM = 115;
    final static int INEG = 116;
    final static int LNEG = 117;
    final static int FNEG = 118;
    final static int DNEG = 119;
    final static int ISHL = 120;
    final static int LSHL = 121;
    final static int ISHR = 122;
    final static int LSHR = 123;
    final static int IUSHR = 124;
    final static int LUSHR = 125;
    final static int IAND = 126;
    final static int LAND = 127;
    final static int IOR = 128;
    final static int LOR = 129;
    final static int IXOR = 130;
    final static int LXOR = 131;
    final static int IINC = 132;
    final static int I2L = 133;
    final static int I2F = 134;
    final static int I2D = 135;
    final static int L2I = 136;
    final static int L2F = 137;
    final static int L2D = 138;
    final static int F2I = 139;
    final static int F2L = 140;
    final static int F2D = 141;
    final static int D2I = 142;
    final static int D2L = 143;
    final static int D2F = 144;
    final static int INT2BYTE = 145;
    final static int INT2CHAR = 146;
    final static int INT2SHORT = 147;
    final static int LCMP = 148;
    final static int FCMPL = 149;
    final static int FCMPG = 150;
    final static int DCMPL = 151;
    final static int DCMPG = 152;
    final static int IFEQ = 153;
    final static int IFNE = 154;
    final static int IFLT = 155;
    final static int IFGE = 156;
    final static int IFGT = 157;
    final static int IFLE = 158;
    final static int IF_ICMPEQ = 159;
    final static int IF_ICMPNE = 160;
    final static int IF_ICMPLT = 161;
    final static int IF_ICMPGT = 163;
    final static int IF_ICMPLE = 164;
    final static int IF_ICMPGE = 162;
    final static int IF_ACMPEQ = 165;
    final static int IF_ACMPNE = 166;
    final static int GOTO = 167;
    final static int JSR = 168;
    final static int RET = 169;
    final static int TABLESWITCH = 170;
    final static int LOOKUPSWITCH = 171;
    final static int IRETURN = 172;
    final static int LRETURN = 173;
    final static int FRETURN = 174;
    final static int DRETURN = 175;
    final static int ARETURN = 176;
    final static int RETURN = 177;
    final static int INVOKEVIRTUAL = 182;
    final static int INVOKENONVIRTUAL = 183;
    final static int INVOKESTATIC = 184;
    final static int INVOKEINTERFACE = 185;
    final static int NEW = 187;
    final static int NEWARRAY = 188;
    final static int ANEWARRAY = 189;
    final static int ARRAYLENGTH = 190;
    final static int ATHROW = 191;
    final static int CHECKCAST = 192;
    final static int INSTANCEOF = 193;
    final static int MONITORENTER = 194;
    final static int MONITOREXIT = 195;
    final static int WIDE = 196;
    final static int MULTIANEWARRAY = 197;
    final static int IFNULL = 198;
    final static int IFNONNULL = 199;
    final static int GOTO_W = 200;
    final static int JSR_W = 201;
    final static int BREAKPOINT = 202;
    final static int RET_W = 209;
}

class RegisterPanel extends Panel {

    private LabeledRegister pcRegister;
    private LabeledRegister optopRegister;
    private LabeledRegister frameRegister;
    private LabeledRegister varsRegister;

    RegisterPanel() {

        setLayout(new BorderLayout(5,5));

        pcRegister = new LabeledRegister(StringTable.pc);
        optopRegister = new LabeledRegister(StringTable.optop);
        frameRegister = new LabeledRegister(StringTable.frame);
        varsRegister = new LabeledRegister(StringTable.vars);

        setBackground(SimData.registersAreaColor);

        Panel labeledRegisterPanel = new Panel();
        labeledRegisterPanel.setLayout(new GridLayout(1, 4, 5, 5));

        labeledRegisterPanel.add(pcRegister);
        labeledRegisterPanel.add(optopRegister);
        labeledRegisterPanel.add(frameRegister);
        labeledRegisterPanel.add(varsRegister);

        Label title = new Label(StringTable.Registers, Label.CENTER);
        title.setFont(new Font("Helvetica", Font.BOLD, 11));
        add("West", title);
        add("Center", labeledRegisterPanel);
    }

    public void setPcRegister(int val) {

        pcRegister.setRegister(val);
    }

    public void setOptopRegister(int val) {

        optopRegister.setRegister(val);
    }

    public void setFrameRegister(int val) {

        frameRegister.setRegister(val);
    }

    public void setVarsRegister(int val) {

        varsRegister.setRegister(val);
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(5, 5, 5, 5);
    }
}

class RepeaterButton extends GrayButton {

    RepeaterButton(String label) {

        super(label);
    }
}

// SimData is like a personality module for the JVMSimulator. It contains all
// the data that is unique to this particular simulation applet.
class SimData {

    public final static String appletTitle = "THREE DIMENSIONAL ARRAY";

    // stackSize, localsSize, and argsSize define the size of the stack for
    // one method, which each simulator executes. These three sizes vary for
    // each method and can be found for a method by running javap -v on the
    // class file. The execEnvSize is constant for every method and only
    // depends on how the JVM was implemented.
    static final int stackSize = 4;
    static final int localsSize = 4;
    static final int argsSize = 0;
    static final int execEnvSize = 4;

    // methodArea sizes are based on the length of the bytecode stream for
    // this method.
    static final int methodAreaMemorySectionSize = 60;
    static final int methodAreaMemoryLocationsVisibleCount = 13;

    // stack sizes are based on the sizes of each portion of the stack (local
    // variables, execution environment, and operands) that are defined above
    // for the method simulated by this applet. One is added to stackMemorySectionSize
    // because this JVM implementation has the optop register pointing to the
    // next available slot in the stack instead of the current top. This means
    // that when the operand stack is full, I still need one more slot to show
    // the location that is pointed to by the optop register, even though we
    // know nothing will ever be pushed there by this method.
    static final int stackMemorySectionSize = stackSize + localsSize + argsSize + execEnvSize + 1;
    static final int stackMemoryLocationsVisibleCount = stackMemorySectionSize;
    static final int frameOffset = (4 * localsSize) + (4 * argsSize); // 4 bytes for each local variable
    static final int optopOffset = frameOffset + (4 * execEnvSize); // 4 bytes for each loc var & exec env slot

    static int[] theProgram = {
            OpCode.ICONST_5,
            OpCode.ICONST_4,
            OpCode.ICONST_3,
            OpCode.MULTIANEWARRAY, (byte) 0x00, (byte) 0x02, (byte) 0x03,
            OpCode.ASTORE_0,
            OpCode.ICONST_0,
            OpCode.ISTORE_1,
            OpCode.GOTO, (byte) 0x00, (byte) 0x2c,
            OpCode.ICONST_0,
            OpCode.ISTORE_2,
            OpCode.GOTO, (byte) 0x00, (byte) 0x1f,
            OpCode.ICONST_0,
            OpCode.ISTORE_3,
            OpCode.GOTO, (byte) 0x00, (byte) 0x12,
            OpCode.ALOAD_0,
            OpCode.ILOAD_1,
            OpCode.AALOAD,
            OpCode.ILOAD_2,
            OpCode.AALOAD,
            OpCode.ILOAD_3,
            OpCode.ILOAD_1,
            OpCode.ILOAD_2,
            OpCode.IADD,
            OpCode.ILOAD_3,
            OpCode.IADD,
            OpCode.IASTORE,
            OpCode.IINC, (byte) 0x03, (byte) 0x01,
            OpCode.ILOAD_3,
            OpCode.ICONST_3,
            OpCode.IF_ICMPLT, (byte) 0xff, (byte) 0xef,
            OpCode.IINC, (byte) 0x02, (byte) 0x01,
            OpCode.ILOAD_2,
            OpCode.ICONST_4,
            OpCode.IF_ICMPLT, (byte) 0xff, (byte) 0xe2,
            OpCode.IINC, (byte) 0x01, (byte) 0x01,
            OpCode.ILOAD_1,
            OpCode.ICONST_5,
            OpCode.IF_ICMPLT, (byte) 0xff, (byte) 0xd5,
            OpCode.BREAKPOINT
    };

    static String[] byteCodeMnemonics = {
            "iconst_5",
            "iconst_4",
            "iconst_3",
            "multianewarray 2 3", "", "", "",
            "astore_0",
            "iconst_0",
            "istore_1",
            "goto +44", "", "",
            "iconst_0",
            "istore_2",
            "goto +31", "", "",
            "iconst_0",
            "istore_3",
            "goto +18", "", "",
            "aload_0",
            "iload_1",
            "aaload",
            "iload_2",
            "aaload",
            "iload_3",
            "iload_1",
            "iload_2",
            "iadd",
            "iload_3",
            "iadd",
            "iastore",
            "iinc 3 1", "", "",
            "iload_3",
            "iconst_3",
            "if_icmplt -17", "", "",
            "iinc 2 1", "", "",
            "iload_2",
            "iconst_4",
            "if_icmplt -30", "", "",
            "iinc 1 1", "", "",
            "iload_1",
            "iconst_5",
            "if_icmplt -43", "", "",
            "breakpoint"
    };

    static final Color appletBackgroundColor = Color.blue;
    static final Color registersAreaColor = Color.cyan;
    static final Color stackAreaColor = Color.cyan;
    static final Color methodAreaColor = Color.cyan;
    static final Color titleColor = Color.green;
    static final Color explanationLabel = Color.green;

}
// StackMemorySection is just used for the stack in this applet. This implements
// the functionality of the stack and has nothing to do with the UI. A separate
// array is used for primitive types and object references because there is no
// way to convert between an object reference and a primitive type (that would
// be a pointer.) The int array (memory) is used to store types boolean, byte,
// char, short, int, long, float, and double. The object reference array (objectMemory)
// is used to store references to objects and arrays.
class StackMemorySection {

    private int[] memory;
    private Object[] objectMemory;
    private int baseAddress;
    private String[] logicalValueString;

    StackMemorySection(int base, int size) {

        baseAddress = base;

        memory = new int[size];
        objectMemory = new Object[size];
        logicalValueString = new String[size];

        for (int i = 0; i < size; ++i) {

            memory[i] = 0;
            logicalValueString[i] = new String();
        }
    }

    public int getAtAddress(int address) {

        return memory[(address - baseAddress) / 4];
    }

    public Object getObjectAtAddress(int address) {

        return objectMemory[(address - baseAddress) / 4];
    }

    public String getLogicalValueAtAddress(int address) {

        return logicalValueString[(address - baseAddress) / 4];
    }

    public void setAtAddress(int address, int value) {

        memory[(address - baseAddress) / 4] = value;
    }

    public void setObjectAtAddress(int address, Object value) {

        objectMemory[(address - baseAddress) / 4] = value;
    }

    public void setLogicalValueAtAddress(int address, String s) {

        logicalValueString[(address - baseAddress) / 4] = s;
    }

}

// StackMemoryView is just used for the stack in this applet.  It implements the
// UI of the stack.
class StackMemoryView extends Panel {

    private final int memoryLocationsVisibleCount = SimData.stackMemoryLocationsVisibleCount;

    private Label[] pointer = new Label[memoryLocationsVisibleCount];
    private Label[] address = new Label[memoryLocationsVisibleCount];
    private Label[] wordValue = new Label[memoryLocationsVisibleCount];
    private Label[] logicalValue = new Label[memoryLocationsVisibleCount];

    StackMemoryView () {

        int[] hComponentCellWidths = new int[4];
        hComponentCellWidths[0] = 2;
        hComponentCellWidths[1] = 2;
        hComponentCellWidths[2] = 2;
        hComponentCellWidths[3] = 3;
        setLayout(new GridSnapLayout(memoryLocationsVisibleCount, 9, hComponentCellWidths));

        setBackground(Color.lightGray);
        Font plainFont = new Font("TimesRoman", Font.PLAIN, 11);
        setFont(plainFont);

        Font italicFont = new Font("TimesRoman", Font.ITALIC, 11);

        for (int i = memoryLocationsVisibleCount - 1; i >= 0; --i) {

            pointer[i] = new Label("", Label.RIGHT);
            pointer[i].setFont(italicFont);
            add(pointer[i]);

            address[i] = new Label("", Label.CENTER);
            add(address[i]);

            wordValue[i] = new Label("", Label.CENTER);
            add(wordValue[i]);

            logicalValue[i] = new Label("", Label.CENTER);
            add(logicalValue[i]);
        }
    }

    public void setAt(int i, int addressValue, int value, String logicalValueString) {

        HexString addressValueString = new HexString(addressValue, 8);
        HexString wordValueString = new HexString(value, 8);

        address[memoryLocationsVisibleCount - 1 - i].setText(addressValueString.getString());
        wordValue[memoryLocationsVisibleCount - 1 - i].setText(wordValueString.getString());
        logicalValue[memoryLocationsVisibleCount - 1 - i].setText(logicalValueString);
    }

    public void update(StackMemorySection memorySection, int initialAddress){

        for (int i = 0; i < memoryLocationsVisibleCount; ++i) {

            int theWord = memorySection.getAtAddress(initialAddress + (i * 4));
            String logicalValue = memorySection.getLogicalValueAtAddress(
                    initialAddress + (i * 4));
            setAt(i, initialAddress + (i * 4), theWord, logicalValue);
        }
    }

    public void clearPointers() {

        for (int i = 0; i < memoryLocationsVisibleCount; ++i) {
            pointer[i].setText("");
        }
    }

    public void updatePointer(int i, String pointerString) {

        pointer[memoryLocationsVisibleCount - 1 - i].setText(pointerString);
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class StackMemoryViewTitlePanel extends Panel {

    StackMemoryViewTitlePanel () {

        int[] hComponentCellWidths = new int[4];
        hComponentCellWidths[0] = 2;
        hComponentCellWidths[1] = 2;
        hComponentCellWidths[2] = 2;
        hComponentCellWidths[3] = 3;
        setLayout(new GridSnapLayout(1, 9, hComponentCellWidths));

        setFont(new Font("Helvetica", Font.ITALIC, 11));

        add(new Label("", Label.CENTER));
        add(new Label(StringTable.address, Label.CENTER));
        add(new Label(StringTable.hexValue, Label.CENTER));
        add(new Label(StringTable.value, Label.CENTER));
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class StackMemoryViewWithTitles extends Panel {

    private StackMemoryView memoryView = new StackMemoryView();

    StackMemoryViewWithTitles () {

        setLayout(new BorderLayout());

        add("North", new StackMemoryViewTitlePanel());
        add("Center", memoryView);
    }

    public StackMemoryView getMemoryViewReference(){

        return memoryView;
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class StackPanel extends Panel {

    private Label title;
    private StackMemoryViewWithTitles memoryView = new StackMemoryViewWithTitles();

    StackPanel() {

        setLayout(new BorderLayout());

        title = new Label("Stack", Label.CENTER);
        title.setFont(new Font("Helvetica", Font.BOLD, 11));

        add("North", title);
        add("Center", memoryView);
    }

    public StackMemoryView getMemoryViewReference() {

        return memoryView.getMemoryViewReference();
    }

    public Insets insets() {
        return new Insets(5, 5, 5, 5);
    }
}


class StringTable {

    public final static String step = "Step";
    public final static String reset = "Reset";
    public final static String run = "Run";
    public final static String stop = "Stop";
    public final static String operand = "operand";
    public final static String execEnv = "exec env";
    public final static String localVars = "local vars";
    public final static String varsPointer = "vars >";
    public final static String framePointer = "frame >";
    public final static String optopPointer = "optop >";
    public final static String address = "address";
    public final static String bytecodes = "bytecode";
    public final static String mnemonics = "mnemonic";
    public final static String hexValue = "hex value";
    public final static String value = "value";
    public final static String Registers = "Registers";
    public final static String pc = "pc";
    public final static String optop = "optop";
    public final static String frame = "frame";
    public final static String vars = "vars";
    public final static String objectReference = "object";
    public final static String objectRefHexRepresentation = "OBJ REF";
    public final static String aaloadText = "aaload will pop an index and array reference and push the object ref at that index of the array.";
    public final static String aload_0Text = "aload_0 will push the object ref at local variable 0 onto the stack.";
    public final static String astore_0Text = "astore_0 will pop the object ref off the top of the stack and store it in local variable 0.";
    public final static String bipushText = "bipush will expand the next byte to an int and push it onto the stack.";
    public final static String breakpointText = "breakpoint will stop the simulation.";
    public final static String fconst_0Text = "fconst_0 will push float 0.0 onto the stack.";
    public final static String fconst_2Text = "fconst_2 will push float 2.0 onto the stack.";
    public final static String fload_0Text = "fload_0 will push the float at local variable 0 onto the stack.";
    public final static String fmulText = "fmul will pop two floats, multiply them, and push the result.";
    public final static String fstore_0Text = "fstore_0 will pop the float off the top of the stack and store it in local variable 0.";
    public final static String fsubText = "fsub will pop two floats, subtract them, and push the result.";
    public final static String gotoText = "goto will cause a jump to the specified offset.";
    public final static String iaddText = "iadd will pop the top two ints off the stack, add them, and push the result back onto the stack.";
    public final static String iandText = "iand will pop the top two ints off the stack, bitwise-and them, and push the result back onto the stack.";
    public final static String iastoreText = "iastore will pop an int value, an index, and an arrayref and assign arrayref[index] = value.";
    public final static String iconst_m1Text = "iconst_m1 will push -1 onto the stack.";
    public final static String iconst_0Text = "iconst_0 will push 0 onto the stack.";
    public final static String iconst_1Text = "iconst_1 will push 1 onto the stack.";
    public final static String iconst_2Text = "iconst_2 will push 2 onto the stack.";
    public final static String iconst_3Text = "iconst_3 will push 3 onto the stack.";
    public final static String iconst_4Text = "iconst_4 will push 4 onto the stack.";
    public final static String iconst_5Text = "iconst_5 will push 5 onto the stack.";
    public final static String if_icmpltText = "if_icmplt will branch if the next to topmost int is less than the topmost int.";
    public final static String ifneText = "ifne will branch if the topmost int is not equal to zero.";
    public final static String iincText = "iinc will increment the specified local variable by the specified amount.";
    public final static String iload_0Text = "iload_0 will push the integer at local variable 0 onto the stack.";
    public final static String iload_1Text = "iload_1 will push the integer at local variable 1 onto the stack.";
    public final static String iload_2Text = "iload_2 will push the integer at local variable 2 onto the stack.";
    public final static String iload_3Text = "iload_3 will push the integer at local variable 3 onto the stack.";
    public final static String imulText = "imul will pop two integers, multiply them, and push the result.";
    public final static String int2byteText = "int2byte will convert the topmost int on the stack to a value valid for the byte type.";
    public final static String iorText = "ior will pop the top two ints off the stack, bitwise-or them, and push the result back onto the stack.";
    public final static String ishlText = "ishl will shift the next to topmost int to the left by amount indicated by topmost int.";
    public final static String istore_0Text = "istore_0 will pop the integer off the top of the stack and store it in local variable 0.";
    public final static String istore_1Text = "istore_1 will pop the integer off the top of the stack and store it in local variable 1.";
    public final static String istore_2Text = "istore_2 will pop the integer off the top of the stack and store it in local variable 2.";
    public final static String istore_3Text = "istore_3 will pop the integer off the top of the stack and store it in local variable 3.";
    public final static String ixorText = "ixor will pop the top two ints off the stack, biwise-xor them, and push the result back onto the stack.";
    public final static String multianewarrayText = "multianewarray will allocate memory for a new multi-dim array and push reference.";
}


class ThreeParts extends Panel {

    private RegisterPanel registers;
    private TwoParts twoParts;

    ThreeParts(int methodAreaMemorySectionSize) {

        setLayout(new BorderLayout(5, 5));
        registers = new RegisterPanel();
        twoParts = new TwoParts(methodAreaMemorySectionSize);
        add("North", registers);
        add("Center", twoParts);
    }

    StackMemoryView getStackMemoryViewReference() {

        return twoParts.getStackMemoryViewReference();
    }

    MemoryView getMethodAreaMemoryViewReference() {

        return twoParts.getMethodAreaMemoryViewReference();
    }

    RegisterPanel getRegisterPanel() {

        return registers;
    }
}

// TwoParts is the panel that contains the Stack and Method Area panels
class TwoParts extends Panel {

    private StackPanel stack;
    private MethodAreaPanel methodArea;

    TwoParts(int methodAreaMemorySectionSize) {

        setLayout(new GridLayout(1, 2, 5, 5));

        stack = new StackPanel();
        methodArea = new MethodAreaPanel(methodAreaMemorySectionSize);

        stack.setBackground(SimData.stackAreaColor);
        methodArea.setBackground(SimData.methodAreaColor);

        add(stack);
        add(methodArea);
    }

    public StackMemoryView getStackMemoryViewReference() {

        return stack.getMemoryViewReference();
    }

    public MemoryView getMethodAreaMemoryViewReference() {

        return methodArea.getMemoryViewReference();
    }

    // top, left, bottom, right
    // Want a 10 pixel separation between the twoparts and the register panel
    // above and the control panel below.
    public Insets insets() {
        return new Insets(0, 0, 0, 0);
    }
}
