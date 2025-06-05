package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {
	
	//GETリクエストの処理
	@GetMapping("/form")
	public String contactForm(Model model) {
		// すでにインスタンスが存在する場合は行わない
        if (!model.containsAttribute("contactForm")) {
            // ビューにフォームクラスのインスタンスを渡す
            model.addAttribute("contactForm", new ContactForm());
        }

        return "contactFormView";
	}
	
	//POSTリクエストの処理
	@PostMapping("/confirm")
	public String confirm(
			@Valid ContactForm form, 
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		// バリデーションエラーがあったら終了
        if (result.hasErrors()) {
            // フォームクラスをビューに受け渡す
            redirectAttributes.addFlashAttribute("contactForm", form);
            // バリデーション結果をビューに受け渡す
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "contactForm", result);
            
            return "redirect:/form";
        }
            
        redirectAttributes.addFlashAttribute("contactForm", form);
        return "confirmView";
	}

}
