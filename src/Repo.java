import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a generic repository.
 * @param <T>
 */
public class Repo<T> {
    private List<T> entities = new ArrayList<>();

    public void create(T entity) {
        entities.add(entity);
    }

//    public T readById(int id) {
//        for (T entity : entities) {
//            try {
//                int entityId = (int) entity.getClass().getDeclaredField("id").get(entity);
//                if (entityId == id) {
//                    return entity;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

    public T readById(int id) {
        for (T entity : entities) {
            try {
                // Access the "id" field via reflection
                var idField = entity.getClass().getDeclaredField("id");
                idField.setAccessible(true); // Allow access to private fields
                Object fieldValue = idField.get(entity);

                // Safely compare the id (considering it might be an Integer)
                if (fieldValue instanceof Integer && (int) fieldValue == id) {
                    return entity;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null; // Return null if no matching entity is found
    }

    public boolean update(T updatedEntity) {
        try {
            // Access the "id" field of the updated entity
            var idField = updatedEntity.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            int updatedEntityId = (int) idField.get(updatedEntity);

            // Iterate through the list and find the entity with the same id
            for (int i = 0; i < entities.size(); i++) {
                var entity = entities.get(i);
                var entityIdField = entity.getClass().getDeclaredField("id");
                entityIdField.setAccessible(true);
                int entityId = (int) entityIdField.get(entity);

                if (entityId == updatedEntityId) {
                    entities.set(i, updatedEntity); // Update the entity
                    return true; // Update successful
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Update failed
    }


    public boolean delete(int id) {
        return entities.removeIf(entity -> {
            try {
                // Access the "id" field via reflection
                var idField = entity.getClass().getDeclaredField("id");
                idField.setAccessible(true); // Allow access to private fields
                int entityId = (int) idField.get(entity);
                return entityId == id;
            } catch (NoSuchFieldException e) {
                System.err.println("Field 'id' does not exist in " + entity.getClass().getName());
            } catch (IllegalAccessException e) {
                System.err.println("Cannot access field 'id' in " + entity.getClass().getName());
            }
            return false;
        });
    }

    public List<T> getAll() {
        return entities;
    }
}
