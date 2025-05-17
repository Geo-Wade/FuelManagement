import com.sun.source.tree.Tree;

import java.util.*;

abstract class Record {
    protected LinkedHashMap<String, Optional<String>> recordFields;

    abstract Map<String, Optional<String>> initRecord();

    abstract boolean assignRecord();

    final Map<String, Optional<String>> getRecordField() {
        return recordFields;
    }
}
