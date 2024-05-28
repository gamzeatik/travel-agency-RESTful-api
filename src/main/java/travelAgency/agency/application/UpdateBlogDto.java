package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UpdateBlogDto {
    UUID id;
    String title;
    String description;
    boolean isActive;
    String imageUrl;
}
