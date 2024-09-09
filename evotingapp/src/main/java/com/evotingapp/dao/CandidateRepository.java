package com.evotingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evotingapp.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
