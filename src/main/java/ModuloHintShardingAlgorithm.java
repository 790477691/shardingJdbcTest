import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Properties;

/**
 * @author xinzhi liu
 * @date 2023/1/1316:20
 * @explain
 */
public class ModuloHintShardingAlgorithm implements HintShardingAlgorithm<String> {

    private Properties props;

    @Override
    public String getType() {
        return "HINT_TEST";
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<String> hintShardingValue) {
        Collection<String> result = new LinkedList<>();
        for (String each : collection) {
            for (String value : hintShardingValue.getValues()) {
                if (each.endsWith(String.valueOf(Long.parseLong(value) % collection.size() + 1))) {
                    result.add(each);
                }
            }
        }
        return result;
    }

    @Override
    public Properties getProps() {
        return this.props;
    }

    @Override
    public void init(Properties properties) {
        this.props = props;
    }
}
