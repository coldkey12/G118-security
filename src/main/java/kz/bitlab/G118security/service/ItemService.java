package kz.bitlab.G118security.service;

import kz.bitlab.G118security.model.Item;
import kz.bitlab.G118security.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item create(Item item) {
        String mark = calculateMark(item.getPoint());
        item.setMark(mark);
        return itemRepository.save(item);
    }

    private String calculateMark(Integer point) {
        if (point == null) {
            return null;
        }
        switch (point) {
            case 1, 2:
                return "B";
            case 3:
                return "NB";
            case 4, 5:
                return "G";
            default:
                return null;
        }
    }

    public Item editItem(Item item) {
        if (item == null) {
            return null;
        }

        Item oldItem = getItemById(item.getId());

        if (oldItem == null) {
            return null;
        }

        if (!item.getPoint().equals(oldItem.getPoint())) {
            String mark = calculateMark(item.getPoint());
            item.setMark(mark);
        }
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    public Item editMark(Long id, Integer point) {
        Item item = getItemById(id);
        String mark = calculateMark(point);
        item.setMark(mark);
        return itemRepository.save(item);
    }
}
