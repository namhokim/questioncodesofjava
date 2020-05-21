package com.example.springboot.sandbox;

import com.example.springboot.sandbox.configure.StorageProperties;
import com.example.springboot.sandbox.repository.MemberRepository;
import com.example.springboot.sandbox.repository.PhoneRepository;
import com.example.springboot.sandbox.repository.entity.Member;
import com.example.springboot.sandbox.repository.entity.Phone;
import com.example.springboot.sandbox.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SandboxApplication implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public static void main(String[] args) {
        SpringApplication.run(SandboxApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

    @Override
    public void run(String... args) {
        final Phone namoPhone1 = new Phone();
        namoPhone1.setPhoneNo("010-1234-5678");

        final Phone namoPhone2 = new Phone();
        namoPhone2.setPhoneNo("010-5678-1234");

        final Member namo = new Member();
        namo.setName("namo");
        namo.addPhone(namoPhone1);
        namo.addPhone(namoPhone2);
        Member saved = memberRepository.save(namo);


//        final Phone namoPhone3 = new Phone();
//        namoPhone3.setPhoneNo("010-1111-2222");
//        namoPhone3.setMember(namo);
//        phoneRepository.save(namoPhone3);

        System.out.println(saved);


//        final Phone phone2 = new Phone("010-YYYY-YYYY");
//        phone2.setMember(savedFirst);
//        phoneRepository.save(phone2);

//        Member second = new Member("Dong");
//        second.addPhone(new Phone("010-ZZZZ-ZZZZ"));
//        memberRepository.save(second);
//
//        Member third = new Member("Min");
//        memberRepository.save(third);

//        System.out.println("Persisted");
//        for (Phone phone : savedFirst.getPhone()) {
//            System.out.println(phone);
//        }

//        System.out.println("findAll");
//        for (Member m : memberRepository.findAll()) {
//            System.out.println(m.toString());
//        }

        //dmr.deleteAll();
    }

}
