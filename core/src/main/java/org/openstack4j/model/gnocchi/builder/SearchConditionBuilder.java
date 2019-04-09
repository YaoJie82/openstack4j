package org.openstack4j.model.gnocchi.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.gnocchi.SearchCondition;


/**
 * This interface describes a builder for {@link SearchCondition} objects
 *
 * @author Jerry
 */
public interface SearchConditionBuilder extends Builder<SearchConditionBuilder, SearchCondition> {
    /**
     * The id of the search
     *
     * @param id the search
     * @return CondtionBuilder
     */
    SearchConditionBuilder id(String id);

    /**
     * The name of the search
     *
     * @param displayName the search
     * @return CondtionBuilder
     */
    SearchConditionBuilder displayName(String displayName);

    /**
     * The instid of the search
     *
     * @param instId the search
     * @return CondtionBuilder
     */
    SearchConditionBuilder instanceId(String instId);

    /**
     * The eq of the search
     *
     * @param eq the search
     * @return CondtionBuilder
     */
    SearchConditionBuilder searchCondition(SearchCondition eq);
}
