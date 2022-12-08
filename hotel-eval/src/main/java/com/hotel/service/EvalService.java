package com.hotel.service;


import com.elio.hotel.domain.Evaluation;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EvalService {
    List<Evaluation> getAll();
    List<Evaluation> getByRoom(Integer roomId);
    List<Evaluation> getByHotel(String hotelId);
    boolean delete(Integer orderId);
    boolean insert(MultipartFile pic, MultipartFile video, HttpServletRequest request);
}
