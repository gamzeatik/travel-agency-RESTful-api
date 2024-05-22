package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.AboutUsService;
import travelAgency.agency.application.CreateAboutUsDto;
import travelAgency.agency.application.UpdateAboutUsDto;
import travelAgency.agency.domain.AboutUs;

import java.util.List;
import java.util.UUID;

@RequestMapping("/about-us")
@RestController
public class AboutUsController {
    private final AboutUsService aboutUsService;

    public AboutUsController(AboutUsService aboutUsService) {
        this.aboutUsService = aboutUsService;
    }

    @GetMapping("/about-list")
    public List<AboutUs> getAboutUsList() {
        return aboutUsService.getAboutUsList();
    }

    @PostMapping("/post-about")
    public AboutUs createAboutUs(@RequestBody CreateAboutUsDto aboutUs) {
        return aboutUsService.createAboutUs(aboutUs);
    }

    @DeleteMapping("/delete-about/{id}")
    public void deleteAboutUs(@PathVariable String id) {
        aboutUsService.deleteAboutUs(UUID.fromString(id));
    }

    @PutMapping("/update-about")
    public AboutUs updateAboutUs(@RequestBody UpdateAboutUsDto aboutUs) {
        return aboutUsService.updateAboutUs(aboutUs);
    }

    @GetMapping("/about/{id}")
    public AboutUs getAboutUs(@PathVariable String id) {
        return aboutUsService.getAboutUs(UUID.fromString(id));
    }
}
