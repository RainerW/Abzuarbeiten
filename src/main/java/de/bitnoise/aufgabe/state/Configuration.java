package de.bitnoise.aufgabe.state;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;

@XStreamAlias("config")
public class Configuration
{

  public Map<String, WindowLayout> layout;

  public WindowLayout getLayout(String key)
  {
    WindowLayout obj = getLayout().get(key);
    if (obj == null)
    {
      obj = new WindowLayout();
      getLayout().put(key, obj);
    }
    return obj;
  }

  Map<String, WindowLayout> getLayout()
  {
    if (layout == null)
    {
      layout = new HashMap<String, WindowLayout>();
    }
    return layout;
  }
}
