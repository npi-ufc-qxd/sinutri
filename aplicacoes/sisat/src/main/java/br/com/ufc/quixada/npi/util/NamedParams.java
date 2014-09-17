package br.com.ufc.quixada.npi.util;



import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class NamedParams implements Map<String, Object>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> realMap;

	
	public NamedParams(Object... entries) {
		putValues(entries);
	}
	
	@SuppressWarnings("unchecked")
	public NamedParams putValues(Object... entries) {
		if (entries.length % 2 != 0)
			throw new IllegalArgumentException("Espera-se número par de objetos: " + entries.length);
		
		if (this.realMap == null)
			this.realMap = new HashMap(entries.length / 2);
		
		for (int i = 0; i < entries.length; i += 2) {
			Object key   = entries[i];
			
			if (! (key instanceof String))
				throw new IllegalArgumentException("O parametro '" + i + "' deveria ser uma String.");
			
			Object value = (i + 1 < entries.length ? entries[i + 1] : null);
			realMap.put((String)key, (Object)value);
		}
		
		return this;
	}
	
	public void clear() {
		realMap.clear();		
	}

	public boolean containsKey(Object key) {
		return realMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return realMap.containsValue(value);
	}

	public Set<Entry<String, Object>> entrySet() {
		return realMap.entrySet();
	}

	public Object get(Object key) {
		return realMap.get(key);
	}

	public boolean isEmpty() {
		return realMap.isEmpty();
	}

	public Set<String> keySet() {
		return realMap.keySet();
	}

	public Object put(String key, Object value) {
		return realMap.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends Object> t) {
		realMap.putAll(t);
	}

	public Object remove(Object key) {
		return realMap.remove(key);
	}

	public int size() {
		return realMap.size();
	}

	public Collection<Object> values() {
		return realMap.values();
	}

	@Override
	public String toString() {
		return realMap.toString();
	}
}