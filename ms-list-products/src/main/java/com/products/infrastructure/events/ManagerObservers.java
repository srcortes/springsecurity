package com.products.infrastructure.events;

import com.products.infrastructure.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ManagerObservers {
  List<ObserverProduct> listeners = new ArrayList<>();

  public void subscribe(ObserverProduct listener) {
    listeners.add(listener);
  }

  public void unsubscribe(ObserverProduct listener) {
     listeners.remove(listener);
  }

  public void notify(List<ProductoEntity> productos) {
    for (ObserverProduct listener : listeners) {
      listener.update(productos);
    }
  }
}
