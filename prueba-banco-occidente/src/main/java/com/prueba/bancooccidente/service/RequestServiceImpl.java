package com.prueba.bancooccidente.service;

import com.prueba.bancooccidente.dto.RequestDTO;
import com.prueba.bancooccidente.dto.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements IRequestService {

	@Override
	public ResponseDTO grupoAutobus(RequestDTO request) {

		String[] data = request.getGroups();
	
		List<Integer> passengerCounts = new ArrayList<>();
		for (String number : data) {
			passengerCounts.add(Integer.parseInt(number));
		}

		int groupCount = passengerCounts.size();
		int totalPassengers = 0;
		for (int count : passengerCounts) {
			totalPassengers += count;
		}

		List<Integer> validBusSizes = new ArrayList<>();
		for (int busSize = 1; busSize <= totalPassengers; busSize++) {
			boolean isContinuing = true;
			int currentGroupIndex = 1;
			boolean isAdding = true;
			int currentIndex = 0;
			boolean isValid = true;
			int remainingSpace = 0;
			while (isContinuing && currentGroupIndex <= groupCount) {
				if (isAdding) {
					remainingSpace = busSize - passengerCounts.get(currentIndex);
				} else {
					remainingSpace -= passengerCounts.get(currentIndex);
				}
				isAdding = remainingSpace > 0 ? false : true;
				if (remainingSpace < 0 || (remainingSpace > 0 && currentGroupIndex == groupCount)) {
					isContinuing = false;
					isValid = false;
				}
				currentIndex++;
				currentGroupIndex++;
			}
			if (isValid) {
				validBusSizes.add(busSize);
			}
		}

		String validBusSizesString = "";
		for (int i = 0; i < validBusSizes.size(); i++) {
			validBusSizesString += validBusSizes.get(i);
			if (i != validBusSizes.size() - 1) {
				validBusSizesString += ",";
			}
		}

		return new ResponseDTO(validBusSizesString);
	}

}
