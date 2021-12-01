package com.practice.spring.rest.exception_handling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//Класс для вывода сообщений об ошибке в json
public class EmployeeIncorrectData {
    private String info;
}