package hello.itemservice.domain.item;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용 (변수타입:long)

    //상품저장
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);//sequence값을 id값으로 저장
        return item;
    }

    //해당id 상품조회
    public Item findById(Long id) {
        return store.get(id);
    }

    //상품전체조회
    public List<Item> findAll() {
        return new ArrayList<>(store.values()); //store값 변하지 않도록 한번 더 감싸는 것을 권장
    }

    //상품수정
    public void update(Long itemId, Item updateParam) {//사용하는 필드만 따로 dto객체 만드는 것을 권장
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    
    //store에 있는 데이터 날림
    public void clearStore() {
        store.clear();
    }
}