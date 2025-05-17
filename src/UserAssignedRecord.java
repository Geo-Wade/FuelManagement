import java.util.Map;
import java.util.Optional;

@FunctionalInterface
public interface UserAssignedRecord {
    void AssignRecordFields(Map<String, Optional<String>> map);
}
