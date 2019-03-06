import java.util.ArrayList;
import java.util.List;

import com.erste.main.util.StopWordFilter;
import com.erste.main.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StopWordFilterTest {

    private static final String TEXT_WITH_STOP_WORDS = "Hello ERSTE Group";
    private static final List<String> STOP_WORDS = new ArrayList<String>() {{
        add("ERSTE");
        add("Group");
    }};

    @Test
    public void filterOutWords() {
        List<String> filteredStrings = new StopWordFilter().filterOutStopWords(STOP_WORDS, StringUtil.getWhiteSpaceSeparatedWordsAsList(TEXT_WITH_STOP_WORDS));
        Assertions.assertEquals(filteredStrings.size(), 1);
        Assertions.assertEquals(filteredStrings.get(0), "Hello");
    }
}