package travelAgency.agency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travelAgency.agency.domain.AboutUs;
import travelAgency.agency.domain.AboutUsRepository;

import java.util.UUID;

@Service
public class AboutUsService {

    private final AboutUsRepository aboutUsRepository;

    public AboutUsService(AboutUsRepository aboutUsRepository) {
        this.aboutUsRepository = aboutUsRepository;
    }

    @Transactional(readOnly = true)
    public AboutUs getAboutUsList() {
        return aboutUsRepository.findAll().get(0);
    }

    @Transactional
    public AboutUs createAboutUs(CreateAboutUsDto aboutUs) {
        var result = new AboutUs(
                UUID.randomUUID(),
                aboutUs.getTitle(),
                aboutUs.getDescription(),
                aboutUs.isActive(),
                aboutUs.getImageUrl()
        );
        return aboutUsRepository.save(result);
    }

//    @Transactional
//    public void deleteAboutUs(UUID id) {
//        aboutUsRepository.deleteById(id);
//    }

    @Transactional
    public AboutUs updateAboutUs(UpdateAboutUsDto aboutUs) {
        var founded = aboutUsRepository.findById(aboutUs.getId());
        if (founded.isPresent()) {
            founded.get().setActive(aboutUs.isActive());
            founded.get().setDescription(aboutUs.getDescription());
            founded.get().setTitle(aboutUs.getTitle());
            founded.get().setImageUrl(aboutUs.getImageUrl());
            return aboutUsRepository.save(founded.get());
        }
        return null;
    }

//    public AboutUs getAboutUs(UUID uuid) {
//        return aboutUsRepository.findById(uuid).orElse(null);
//    }
}
