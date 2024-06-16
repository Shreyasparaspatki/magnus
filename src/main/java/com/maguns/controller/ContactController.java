package com.maguns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maguns.pojo.ContactPojo;
import com.maguns.serivce.ContactSerivce;

@Controller
public class ContactController {
	@Autowired
	private ContactSerivce contactService;

	@GetMapping("/")
	public String contact() {
		return "index";
	}

	@PostMapping("/index")
	public String add(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("country") String country, @RequestParam("city") String city,
			@RequestParam("mobile") String mobile, RedirectAttributes redirectAttributes,
            ModelMap model) {
		ContactPojo contactPojo = new ContactPojo();
		contactPojo.setName(name);
		contactPojo.setEmail(email);
		contactPojo.setCountry(country);
		contactPojo.setCity(city);
		contactPojo.setMobile(mobile);
		contactService.saveContactPojo(contactPojo);
		redirectAttributes.addFlashAttribute("successMessage", "submitted successfully!");

		// Add any other attributes to the model if needed
		model.addAttribute("contactname",contactPojo);

		return "redirect:/"; // Redirect to the same page
		// OR redirect to a different success page:
		// return "redirect:/success";
	}

	@GetMapping("/getAll")
	public String getAllUserPojos(ModelMap modelMap) {
//		userService.getAllUserPojos();
		List<ContactPojo> list = contactService.getAllContactPojos();
		modelMap.addAttribute("contacts", list);
		return "Viewproject";
	}

}
