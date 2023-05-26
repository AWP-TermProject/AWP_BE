package team.buildup.reviewservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {
    final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/api/review")
    public String create(@RequestBody Review review) {
        reviewRepository.save(review);
        return "create ok"; }
    @GetMapping("/api/review/{id}")
    public Optional<Review> show(@PathVariable("id") Long id) {
        return reviewRepository.findById(id); }
    @GetMapping("/api/reviews") public List<Review> showAll() {
        return reviewRepository.findAll(); }

    @PutMapping("/api/review/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Review review){
        Optional<Review> reviewUpdate = reviewRepository.findById(id);
        if (reviewUpdate.isPresent()) {
            Review _review = reviewUpdate.get();
            _review.setTitle(review.getTitle());
            _review.setContents(review.getContents());

            return new ResponseEntity<>(reviewRepository.save(_review), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } }

    @DeleteMapping("/api/review/{id}")
    public String delete(@PathVariable("id") Long id) {
        reviewRepository.deleteById(id);
        return "delete ok"; }


}
