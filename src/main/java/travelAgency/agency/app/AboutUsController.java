package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.AboutUsService;
import travelAgency.agency.application.CreateAboutUsDto;
import travelAgency.agency.application.UpdateAboutUsDto;
import travelAgency.agency.domain.AboutUs;

@CrossOrigin(origins = "https://www.comfortabletransfer.com")
@RequestMapping("/about-us")
@RestController
public class AboutUsController {
    private final AboutUsService aboutUsService;

    public AboutUsController(AboutUsService aboutUsService) {
        this.aboutUsService = aboutUsService;
    }

    @GetMapping("/about")
    public AboutUs getAboutUsList() {
        return aboutUsService.getAboutUsList();
    }

    @PostMapping("/post-about")
    public AboutUs createAboutUs(@RequestBody CreateAboutUsDto aboutUs) {
        return aboutUsService.createAboutUs(aboutUs);
    }

    @PutMapping("/update-about")
    public AboutUs updateAboutUs(@RequestBody UpdateAboutUsDto aboutUs) {
        return aboutUsService.updateAboutUs(aboutUs);
    }
//
//    @DeleteMapping("/delete-about/{id}")
//    public void deleteAboutUs(@PathVariable String id) {
//        aboutUsService.deleteAboutUs(UUID.fromString(id));

//    }
//
//    @GetMapping("/about/{id}")
//    public AboutUs getAboutUs(@PathVariable String id) {
//        return aboutUsService.getAboutUs(UUID.fromString(id));
//    }
}
