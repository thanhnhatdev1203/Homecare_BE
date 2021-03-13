package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.BookingConvert;
import com.homecare.Homecare.dto.BookingDTO;
import com.homecare.Homecare.entity.BookingEntity;
import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.BookingRepository;
import com.homecare.Homecare.repository.ComboRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BookingConvert bookingConvert;

	@Transactional
	public SuccessResponse edit(BookingDTO bookingDTO) {
		if (this.findById(bookingDTO.getId()) == null)
			throw new NotFoundException("");
		{
			Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingDTO.getId());
			BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new BadRequestException("ID not correct"));
			bookingEntity.setAddress(bookingDTO.getAddress());
			bookingEntity.setBrand(bookingDTO.getBrand());
			bookingEntity.setDate(bookingDTO.getDate());
			bookingEntity.setDescription(bookingDTO.getDescription());
			bookingEntity.setDistrict(bookingDTO.getDistrict());
			bookingEntity.setEmail(bookingDTO.getEmail());
			bookingEntity.setFullname(bookingDTO.getFullname());
			bookingEntity.setId(bookingDTO.getId());
			bookingEntity.setPhone(bookingDTO.getPhone());
			bookingEntity.setProduct(bookingDTO.getProduct());
			bookingEntity.setProvince(bookingDTO.getProvince());
			bookingEntity.setService(bookingDTO.getService());
			bookingConvert.entityToDTO(bookingRepository.save(bookingEntity));
		}
		return new SuccessResponse();
	}

	@Transactional
	public SuccessResponse save(BookingDTO bookingDTO) {
		BookingEntity bookingEntity = new BookingEntity();
		
			UUID id = UUID.randomUUID();
			bookingDTO.setId(id.toString());
			bookingEntity.setAddress(bookingDTO.getAddress());
			bookingEntity.setBrand(bookingDTO.getBrand());
			bookingEntity.setDate(bookingDTO.getDate());
			bookingEntity.setDescription(bookingDTO.getDescription());
			bookingEntity.setDistrict(bookingDTO.getDistrict());
			bookingEntity.setEmail(bookingDTO.getEmail());
			bookingEntity.setFullname(bookingDTO.getFullname());
			bookingEntity.setPhone(bookingDTO.getPhone());
			bookingEntity.setProduct(bookingDTO.getProduct());
			bookingEntity.setProvince(bookingDTO.getProvince());
			bookingEntity.setService(bookingDTO.getService());
			bookingRepository.save(bookingEntity);

		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setCode(201);
		return successResponse ;
	}

	public SuccessResponse findById(String idBooking) {
		Optional<BookingEntity> optionalBooking = bookingRepository.findById(idBooking);
		if (optionalBooking.isPresent()) {
			return new SuccessResponse(this.bookingConvert.entityToDTO(optionalBooking.get()));
		}
		return new SuccessResponse();
	}

	public SuccessResponse findAllBooking() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setData(bookingRepository.findAll());
		return successResponse;
	}
}
