package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateBlogDto {
    String title;
    String description;
    boolean isActive;
    String imageUrl;
}
