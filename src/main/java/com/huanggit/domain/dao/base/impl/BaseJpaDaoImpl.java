package com.huanggit.domain.dao.base.impl;

import com.huanggit.domain.dao.base.BaseJpaDao;
import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.general.dto.common.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017-12-01-0001.
 */
public class BaseJpaDaoImpl<T extends BaseEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseJpaDao<T, ID> {

    private final JpaEntityInformation<T, ?> entityInformation;
    private Class<T> domainClass;
    private EntityManager em;

    public BaseJpaDaoImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
        this.domainClass = entityInformation.getJavaType();
    }

    @Override
    public PageInfo<T> query(PageInfo<T> var1, Map<String, Object> var2, Map<String, Boolean> var3) {
        Specification<T> spec = this.buildSpecification(var2);
        Sort sort = this.buildSort(var3);
        Pageable pageable = new PageRequest(var1.getCurrentPage() - 1, var1.getPageSize(), sort);
        Page<T> page = this.findAll(spec, pageable);
        var1.setPageResult(page.getContent());
        var1.setTotalCount(page.getTotalElements());
        var1.setTotalPage((long)page.getTotalPages());
        return var1;
    }

    private Specification<T> buildSpecification(Map<String, Object> map) {
        return new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.conjunction();
            }
        };
    }

    private Sort buildSort(Map<String, Boolean> orderMap) {
        List<Sort.Order> orders = new ArrayList();
        if(orderMap != null && orderMap.size() > 0) {
            Iterator var3 = orderMap.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<String, Boolean> entry = (Map.Entry)var3.next();
                orders.add(new Sort.Order(((Boolean)entry.getValue()).booleanValue()? Sort.Direction.ASC: Sort.Direction.DESC, (String)entry.getKey()));
            }
        } else {
            orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
        }

        Sort sort = new Sort(orders);
        return sort;
    }
}
