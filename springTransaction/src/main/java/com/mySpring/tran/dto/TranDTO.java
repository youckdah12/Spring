package com.mySpring.tran.dto;

import com.mySpring.tran.dto.TranDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranDTO {

	private String consumerId;
	private int amount;
}
