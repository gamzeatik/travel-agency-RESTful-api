package travelAgency.agency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travelAgency.agency.domain.Blogs;
import travelAgency.agency.domain.BlogsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BlogsService {
    private final BlogsRepository blogsRepository;

    public BlogsService(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    public List<Blogs> getBlogList() {
        return blogsRepository.findAll();
    }

    @Transactional
    public Blogs createBlog(CreateBlogDto blogs) {
        var result = new Blogs(
                UUID.randomUUID(),
                blogs.getTitle(),
                blogs.getDescription(),
                blogs.isActive()
        );
        return blogsRepository.save(result);
    }

    public void deleteBlog(UUID uuid) {
        blogsRepository.deleteById(uuid);
    }

    @Transactional
    public Blogs updateBlog(UpdateBlogDto blogs) {
        var founded = blogsRepository.findById(blogs.getId());
        if (founded.isPresent()) {
            founded.get().setTitle(blogs.getTitle());
            founded.get().setDescription(blogs.getDescription());
            founded.get().setActive(blogs.isActive());
            return blogsRepository.save(founded.get());
        }
        return null;
    }

    public Blogs getBlog(UUID uuid) {
        return blogsRepository.findById(uuid).orElse(null);
    }
}
