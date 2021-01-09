package com.innospeech.customManager.dto;

import org.springframework.data.jpa.domain.Specification;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;

import com.innospeech.customManager.model.Board;
import com.innospeech.customManager.model.Users;

public class BoardSpecification {

	public static Specification<Board> titleLike(final String keyword) {
		return new Specification<Board>() {
			@Override
			public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get("title"), "%" + keyword + "%");
			}
		};   // return값은 Predicate 타입이다
	}
	
	public static Specification<Board> contentLike(final String keyword) {
		return new Specification<Board>() {
			@Override
			public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				return cb.like(root.get("content"), "%" + keyword + "%");
			}
		};   // return값은 Predicate 타입이다
	}
	
	
	
	public static Specification<Board> category(final String category) {
        return new Specification<Board>() {
            @Override
            public Predicate toPredicate(Root<Board> root,
                    CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("d"), category);
                
            }
        };   // return값은 Predicate 타입이다
    }
	public static Specification<Board> findByFirstNmLastNmEmail(String firstNm, String lastNm, String email) {
        return new Specification<Board>() {
            @Override
            public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate firstNmPredicate = null;
                 Predicate lastNmPredicate = null;
                 Predicate emailPredicate = null;

                if (!StringUtils.isEmpty(firstNm)) {
                    firstNmPredicate = cb.like(root.get(""),  "%" +"keword"+ "%");
                }
                if (!StringUtils.isEmpty(lastNm)) {
                    lastNmPredicate = cb.like(root.get(""),  "%" +"keword"+ "%");
                }
                if (!StringUtils.isEmpty(email)) {
                    emailPredicate = cb.like(root.get(""),  "%" +"keword"+ "%");
                }
                return cb.and(firstNmPredicate, lastNmPredicate, emailPredicate);
            }
        };
    }
}
