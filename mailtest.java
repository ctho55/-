package Test;

import javax.mail.internet.MimeMessage;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class mailtest {
	
	public static void main (String[] args) {
		
		mailtest m = new mailtest();
		
		m.mailTest();
}
	public void mailTest() {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				"Test/emailtest.xml");
			
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl)ctx.getBean("mailSender");
		
		// 메일 제목, 내용
		String subject = "제목입니당";
		String content = "내용입니당~";
		
		// 보내는 사람
		String from = "ctho55@naver.com";
		
		// 받는 사람
		String[] to = new String[2];
		to[0] = "sk77424598@gmail.com";
		to[1] = "ctho55@naver.com";
		
		try {
			// 메일 내용 넣을 객체와, 이를 도와주는 Helper 객체 생성
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
			
			// 메일 내용을 채워줌
			mailHelper.setFrom(from);	// 보내는 사람 셋팅
			mailHelper.setTo(to);		// 받는 사람 셋팅
			mailHelper.setSubject(subject);	// 제목 셋팅
			mailHelper.setText(content);	// 내용 셋팅
			
			// 메일 전송
			mailSender.send(mail);
			ctx.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}