package com.infoplus.hopital.repository.specifications.base;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Collection;
import java.util.function.Function;

public abstract class BaseQuerySpecification<B> {

    public Specification<B> initWhere() {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.conjunction();
        });
    }

    public String wrapLikeQuery(Object value) {
        return "%" + String.valueOf(value).toUpperCase() + "%";
    }

    //like
    public Specification<B> likeSpecification(String isField, Object value) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(isField)), wrapLikeQuery(value));
    }

    //equals
    public Specification<B> equalSpecification(String isField, Object object) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(isField), object);
    }

    //in
    public <X> Specification<B> inSpecification(Function<Root<B>, Expression<X>> metaClassFunction,
                                                final Collection<X> values) {
        return ((root, query, criteriaBuilder) -> {
            CriteriaBuilder.In<X> in = criteriaBuilder.in(metaClassFunction.apply(root));
            for (X value : values) {
                in = in.value(value);
            }
            return in;
        });
    }

    //join one to many
    public <R, J, F extends Comparable<? super F>> Specification<B> buildJoinSpecification(Filter<F> filter, SingularAttribute<? super B, R> reference, SingularAttribute<J, F> valueField) {
        Specification<B> result = null;
        if (filter.getEquals() != null) {
            result = this.equalsOfJoint(reference, valueField, filter.getEquals());
        }
        if (filter.getLike() != null) {
            result = this.likeOfJoint(reference, valueField, filter.getLike());
        }
        return result;
    }

    //filter equals
    private <R, J, F> Specification<B> equalsOfJoint(SingularAttribute<? super B, R> reference, SingularAttribute<J, F> idField, F value) {
        return (root, query, builder) -> builder.equal(root.join(reference).get(idField.getName()), value);
    }

    //filter equals
    private <R, J, F> Specification<B> likeOfJoint(SingularAttribute<? super B, R> reference, SingularAttribute<J, F> idField, F value) {
        return (root, query, builder) -> builder.like(builder.lower(root.join(reference).get(idField.getName())), wrapLikeQuery(value.toString()));
    }



    //join many to many
    public <R, J, F extends Comparable<? super F>> Specification<B> buildJoinSpecification(Filter<F> filter, ListAttribute<? super B, R> reference, SingularAttribute<R, J> joinField, SingularAttribute<J, F> valueField) {
        Specification<B> result = null;
        if (filter.getEquals() != null) {
            result = this.equalsOfJoint(reference, joinField, valueField, filter.getEquals());
        }
        if (filter.getLike() != null) {
            result = this.likeOfJoint(reference, joinField, valueField, filter.getLike());
        }
        if (filter.getIn() != null) {
            result = this.valueInOfJoint(reference, joinField, valueField, filter.getIn());
        }
        return result;
    }

    private <R, J, F> Specification<B> likeOfJoint(ListAttribute<? super B, R> reference, SingularAttribute<R, J> joinField, SingularAttribute<J, F> idField, F value) {
        return (root, query, builder) -> builder.like(builder.lower(root.join(reference).join(joinField).get(idField.getName())), wrapLikeQuery(value.toString()));
    }
    //filter equals
    private <R, J, F> Specification<B> equalsOfJoint(ListAttribute<? super B, R> reference, SingularAttribute<R, J> joinField, SingularAttribute<J, F> idField, F value) {
        return (root, query, builder) -> builder.equal(root.join(reference).join(joinField).get(idField), value);
    }

    //filter in
    private <R, J, F> Specification<B> valueInOfJoint(ListAttribute<? super B, R> reference, SingularAttribute<R, J> joinField, SingularAttribute<J, F> valueField, Collection<F> values) {
        return (root, query, builder) -> {
            CriteriaBuilder.In<F> in = builder.in(root.join(reference).join(joinField).get(valueField));
            for (F value : values) {
                in = in.value(value);
            }
            return in;
        };
    }

}
