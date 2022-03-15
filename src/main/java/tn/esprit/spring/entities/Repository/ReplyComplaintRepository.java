package tn.esprit.spring.entities.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.ReplyComplaint;

@Repository

public interface ReplyComplaintRepository extends CrudRepository<ReplyComplaint, Long> {

}
