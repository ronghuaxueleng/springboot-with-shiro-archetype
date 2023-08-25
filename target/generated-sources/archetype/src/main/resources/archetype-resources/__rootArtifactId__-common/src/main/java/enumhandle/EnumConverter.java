#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.enumhandle;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.lang.reflect.Type;

public class EnumConverter implements ObjectDeserializer, ObjectSerializer {
  @Override
  public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
    final JSONLexer lexer = defaultJSONParser.lexer;
    Class cls = (Class) type;
    Object[] enumConstants = cls.getEnumConstants();
    for (Object enumConstant : enumConstants) {
      BaseEnum baseEnum = (BaseEnum) enumConstant;
      if (baseEnum.getValue() == lexer.intValue()) {
        return (T) baseEnum;
      }
    }
    return null;
  }

  @Override
  public int getFastMatchToken() {
    return JSONToken.LITERAL_INT;
  }

  @Override
  public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) {
    SerializeWriter out = jsonSerializer.out;
    if (o instanceof BaseEnum) {
      BaseEnum baseEnum = (BaseEnum) o;
      out.writeInt(baseEnum.getValue());
    } else {
      out.writeEnum((Enum<?>) o);
    }
  }
}
