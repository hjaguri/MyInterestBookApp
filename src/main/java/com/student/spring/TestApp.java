package com.student.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.student.spring.beans.CustomerVo;
import com.student.spring.config.AppConfig;
import com.student.spring.controller.CustomerController;

public class TestApp {

    public static void main(String[] args) {

        // 🌱 Starting the Spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scanner = new Scanner(System.in);

        // 💬 Welcome Banner
        System.out.println("\n============================================");
        System.out.println("📅 Welcome to Simple Interest Register 📅");
        System.out.println("============================================\n");

        // 📝 Reading inputs
        System.out.print("👤 Enter Customer Name        : ");
        String name = scanner.nextLine();

        System.out.print("🏠 Enter Customer Address     : ");
        String address = scanner.nextLine();

        System.out.print("💰 Enter Principal Amount     : ");
        String pamt = scanner.nextLine();

        System.out.print("📈 Enter Rate of Interest (%) : ");
        String rate = scanner.nextLine();

        System.out.print("⏳ Enter Time Period (months) : ");
        String time = scanner.nextLine();

        try {
            // 💡 Preparing VO
            CustomerVo vo = new CustomerVo();
            vo.setCustName(name);
            vo.setCustAddr(address);
            vo.setPamt(pamt);
            vo.setRate(rate);
            vo.setTime(time);

            // 🧠 Getting controller bean
            CustomerController controller = context.getBean("controller", CustomerController.class);

            // 📊 Processing and displaying result
            String status = controller.processCustomer(vo);
            System.out.println("\n📣 " + status);

        } catch (Exception e) {
            System.out.println("❌ Some internal problem occurred ---> Try again.");
            System.out.println("🔧 Error: " + e.getMessage());
        }

        // 🛑 Closing resources
        ((AbstractApplicationContext) context).close();
        scanner.close();

        System.out.println("\n📌 Thank you for using the Interest Register App!\n");
    }
}
