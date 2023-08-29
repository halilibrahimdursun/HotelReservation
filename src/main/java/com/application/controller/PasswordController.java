package com.application.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Properties;

@Controller
public class PasswordController {

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String email) {
        // Подключение к почтовому серверу
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.ukr.net");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("name", "pass");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("name"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Reset password");

            String resetLink = "http://localhost:8080/reset-password/" + generateResetCode();
            String emailContent = "Hello,<br><br>"
                    + "To reset your password, go to the following link:<br>"
                    + "<a href=\"" + resetLink + "\">" + resetLink + "</a><br><br>"
                    + "Sincerely,<br>"
                    + "Your Molveno teams";

            message.setContent(emailContent, "text/html; charset=utf-8");

            Transport.send(message);
        } catch (MessagingException e) {
            // Обработка ошибок отправки письма
            e.printStackTrace();
        }

        return "redirect:/login?reset";
    }

    @GetMapping("/reset-password/{token}")
    public String showResetPasswordForm(@PathVariable("token") String token, Model model) {
        // Проверка действительности токена сброса пароля
        model.addAttribute("token", token);
        return "reset-password";
    }

    @PostMapping("/set-new-password")
    public String processSetNewPassword(@RequestParam("token") String token,
                                        @RequestParam("password") String password,
                                        @RequestParam("confirmPassword") String confirmPassword) {
        // Проверка длины пароля (минимум 6 символов)
        if (password.length() < 6) {
            return "redirect:/set-new-password?token=" + token + "&error=short";
        }

        // Проверка наличия хотя бы одной цифры в пароле
        if (!password.matches(".*\\d.*")) {
            return "redirect:/set-new-password?token=" + token + "&error=no-digit";
        }

        // Проверка наличия хотя бы одной буквы в верхнем регистре в пароле
        if (!password.matches(".*[A-Z].*")) {
            return "redirect:/set-new-password?token=" + token + "&error=no-uppercase";
        }

        // Проверка совпадения паролей
        if (!password.equals(confirmPassword)) {
            return "redirect:/set-new-password?token=" + token + "&error=not-matching";
        }

        // Пароль прошел все проверки, выполните необходимые действия для установки нового пароля
        // ...

        return "redirect:/login?password-reset";
    }

    @GetMapping("/set-new-password") // Новый метод для обработки GET-запросов
    public String showSetNewPasswordForm(@RequestParam("token") String token, Model model) {
        // Логика для отображения формы установки нового пароля
        model.addAttribute("token", token);
        return "set-new-password";
    }

    private String generateResetCode() {
        // Реализуйте генерацию уникального кода сброса пароля, например, с использованием UUID или другого метода
        return "your-reset-code";
    }
}
