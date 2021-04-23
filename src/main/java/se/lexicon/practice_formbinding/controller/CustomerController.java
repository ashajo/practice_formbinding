package se.lexicon.practice_formbinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.lexicon.practice_formbinding.data.CustomerDao;
import se.lexicon.practice_formbinding.dto.CustomerFormDto;
import se.lexicon.practice_formbinding.entity.Customer;
import se.lexicon.practice_formbinding.entity.CustomerDetails;

import javax.validation.Valid;


@Controller
public class CustomerController {
    private CustomerDao customerDao;
    @Autowired
    public CustomerController(CustomerDao customerDao){
        this.customerDao=customerDao;
    }

    @GetMapping("/customers")
    public String findAll(Model model){
        model.addAttribute("customers",customerDao.findAll());
        return "customers";
    }
    @GetMapping("customer/create")
    public String getForm(Model model) {
        CustomerFormDto customerFormDto = new CustomerFormDto();
        model.addAttribute("customerForm", customerFormDto);
        return "create-customer";
    }


    @PostMapping("customer/process")
    public String create(@Valid @ModelAttribute("customerForm")CustomerFormDto customerFormDto, BindingResult bindingResult) {
        if (customerDao.findByEmail(customerFormDto.getEmail()).isPresent()) {
            FieldError error = new FieldError("customerForm", "email", "Email:"+customerFormDto.getAdress()+
                    "is already defined");

            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            return "create-customer";
        }
        Customer newCustomer = new Customer(customerFormDto.getEmail(), new CustomerDetails(

                customerFormDto.checkCityIsEmpty(customerFormDto.getCity()),
                customerFormDto.getZipCode(),
                customerFormDto.getHomePhone(),
                customerFormDto.getCellPhone()));
        newCustomer = customerDao.save(newCustomer);
        return "redirect:/customers";
    }


    @GetMapping("/customerDetails")
    public String find(@RequestParam("id")String customerId,Model model){
        Customer customer=customerDao.findById(customerId).get();
        model.addAttribute("customer",customer);

        return "customerDetails";
    }


}
