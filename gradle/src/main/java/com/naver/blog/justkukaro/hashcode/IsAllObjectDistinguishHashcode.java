package com.naver.blog.justkukaro.hashcode;

import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class IsAllObjectDistinguishHashcode {
    public static void main(String[] args) {
        System.out.println(getHashCodeSetting());
        System.out.println();

        Map<Integer, Object> objectMap = new HashMap<>();

        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE + 1L; i++) {
            Object obj = new Object();
            int hashCode = obj.hashCode();

            Object beforeObj = objectMap.get(hashCode);
            if (beforeObj != null) {
                System.out.println("Repeat " + (i - Integer.MIN_VALUE + 1L));
                System.out.println("before: " + beforeObj.hashCode());
                System.out.println("later: " + obj.hashCode());
                System.out.println("Is same: " + beforeObj == obj);
                return;
            }

            objectMap.put(hashCode, obj);
        }
    }

    // source: https://stackoverflow.com/questions/16994582/within-a-running-jvm-how-to-programmatically-determine-the-jvm-options-used-at
    private static String getHashCodeSetting() {
        // load the diagnostic bean first to avoid UnsatisfiedLinkError
        final HotSpotDiagnosticMXBean hsdiag = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        try {
            final Class<?> flagClass = Class.forName("sun.management.Flag");
            final Method getAllFlagsMethod = flagClass.getDeclaredMethod("getAllFlags");
            final Method getVMOptionMethod = flagClass.getDeclaredMethod("getVMOption");
            getAllFlagsMethod.setAccessible(true);
            getVMOptionMethod.setAccessible(true);
            final Object result = getAllFlagsMethod.invoke(null);
            final List<?> flags = (List<?>) result;
            for (final Object flag : flags) {
                final VMOption vmOption = (VMOption) getVMOptionMethod.invoke(flag);
                if (vmOption.getName().equals("hashCode")) {
                    return getPrettyString(vmOption);
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException | ClassCastException e) {
            if (hsdiag != null) {
                // only includes writable external flags
                List<VMOption> options = hsdiag.getDiagnosticOptions();
                for (VMOption vmOption : options) {
                    if (vmOption.getName().equals("hashCode")) {
                        return getPrettyString(vmOption);
                    }
                }
            }
        }
        return "Cannot found 'hashCode' option.";
    }

    private static String getPrettyString(VMOption option) {
        return option.getName() + " = " + option.getValue() + " (" +
                option.getOrigin() + ", " +
                (option.isWriteable() ? "read-write" : "read-only") + ")";
    }
}
