package org.openstack4j.model.gnocchi.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.gnocchi.MeasureSearchInput;
import org.openstack4j.model.gnocchi.SearchCondition;


/**
 * This interface describes a builder for {@link org.openstack4j.model.gnocchi.SearchCondition} objects
 *
 * @author Jerry
 */
public interface MeasureSearchBuilder extends Builder<MeasureSearchBuilder, MeasureSearchInput> {
    /**
     * The id of the search
     *
     * @param operations the search
     * @return CondtionBuilder
     */
    MeasureSearchBuilder operations(String operations);

    /**
     * The name of the search
     *
     * @param resouceType the search
     * @return CondtionBuilder
     */
    MeasureSearchBuilder resourceType(MeasureSearchInput.ResouceType resouceType);

    /**
     * The instid of the search
     *
     * @param searchCondition the search
     * @return CondtionBuilder
     */
    MeasureSearchBuilder search(SearchCondition searchCondition);

}
