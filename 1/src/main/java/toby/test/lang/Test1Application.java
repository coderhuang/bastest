package toby.test.lang;

import java.util.Scanner;

public class Test1Application {

	public static void main(String[] args) {

		System.err.println("啊哈");
		try (Scanner scanner = new Scanner(System.in);) {

			String input = scanner.nextLine();
			System.err.println(input);
			
			System.out.println("Java 安装目录："+System.getProperty("java.home"));
			System.out.println("所使用的open jdk的发行商："+System.getProperty("java.vendor"));
			System.out.println("所使用的open jdk的发行商链接："+System.getProperty("java.vendor.url"));

			System.out.println("操作系统："+System.getProperty("os.name"));
			System.out.println("操作系统架构："+System.getProperty("os.arch"));
			System.out.println("操作系统的版本："+System.getProperty("os.version"));
		}

	}

}
