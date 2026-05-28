package com.amitmourya8085.blog.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String email;
}
