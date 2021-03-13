package com.homecare.Homecare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.Homecare.dto.BookingDTO;
import com.homecare.Homecare.dto.BrandDTO;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.service.BookingService;

@RestController
@RequestMapping("api/v1")
public class BookingController {
@Autowired
private BookingService bookingService ;

@GetMapping("/booking")
public SuccessResponse<BookingDTO> findAll(){
	return bookingService.findAllBooking();
}
@GetMapping("/booking/{id}")
public SuccessResponse<BookingDTO> findById(@PathVariable String id){
	return bookingService.findById(id) ;
}
@PostMapping("/add/booking")
public SuccessResponse addBrand(@RequestBody BookingDTO bookingDTO) {
	return this.bookingService.save(bookingDTO) ;
}	
}