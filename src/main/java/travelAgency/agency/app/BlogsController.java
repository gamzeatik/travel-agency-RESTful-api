package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.BlogsService;
import travelAgency.agency.application.CreateBlogDto;
import travelAgency.agency.application.UpdateBlogDto;
import travelAgency.agency.domain.Blogs;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    private final BlogsService blogsService;

    public BlogsController(BlogsService blogsService) {
        this.blogsService = blogsService;
    }

    @GetMapping("/blog-list")
    public List<Blogs> getBlogList() {
        return blogsService.getBlogList();
    }

    @PostMapping("/post-blog")
    public Blogs createBlog(@RequestBody CreateBlogDto blogs) {
        return blogsService.createBlog(blogs);
    }

    @DeleteMapping("/delete-blog/{id}")
    public void deleteBlog(@PathVariable String id) {
        blogsService.deleteBlog(UUID.fromString(id));
    }

    @PutMapping("/update-blog")
    public Blogs updateBlog(@RequestBody UpdateBlogDto blogs) {
        return blogsService.updateBlog(blogs);
    }

    @GetMapping("/blog/{id}")
    public Blogs getBlog(@PathVariable String id) {
        return blogsService.getBlog(UUID.fromString(id));
    }
}
