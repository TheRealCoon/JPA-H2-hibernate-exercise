package com.example.bookapimanytomany.model;

import com.example.bookapimanytomany.validator.NoSingleWordValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
//    @NotBlank(message = "Title must not be empty!")
    @NoSingleWordValidator
    private String title;
    private List<Long> authorIds;
}
