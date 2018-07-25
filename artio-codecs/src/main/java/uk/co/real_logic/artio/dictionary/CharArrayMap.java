/*
 * Copyright 2015-2017 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.real_logic.artio.dictionary;

import java.util.Map;
import java.util.stream.Collectors;

public final class CharArrayMap<V>
{
    private final CharArrayWrapper wrapper = new CharArrayWrapper();
    private final Map<CharArrayWrapper, V> map;

    public CharArrayMap(final Map<String, V> buildFrom)
    {
        this.map = buildFrom
            .entrySet()
            .stream()
            .collect(Collectors.toMap((entry) -> new CharArrayWrapper(entry.getKey()), Map.Entry::getValue));
    }

    public V get(final char[] value, final int length)
    {
        wrapper.wrap(value, length);
        return map.get(wrapper);
    }

    public boolean containsKey(final char[] value, final int length)
    {
        wrapper.wrap(value, length);
        return map.containsKey(wrapper);
    }

    public boolean containsKey(final char[] value, final int offset, final int length)
    {
        wrapper.wrap(value, offset, length);
        return map.containsKey(wrapper);
    }
}