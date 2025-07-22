package com.mashtura.crawler.entity;

import java.util.List;
import java.util.Map;

public interface EntityData {

    String getEntityId();

    String getEntityType(); // "PERSON" or "ORGANIZATION" or other, as needed

    List<String> getAddress();

    List<String> getAssociatedEntities(); // Comma-separated list of associated entity IDs

    List<String> getSource(); // Source of the data, e.g., "web", "database", etc.

    List<String> getEvents(); // Comma-separated list of events associated with the entity

    String findById(String entityId); // Method to find an entity by its ID

    String getEntityName(); // Name of the entity, e.g., "John Doe" or "Acme Corp"

    EntityRecords updateEntity(String entityId, Map newData, EntityRecords entity);
}
