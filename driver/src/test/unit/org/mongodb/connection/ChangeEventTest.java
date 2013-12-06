/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb.connection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ChangeEventTest {
    @Test
    public void testAll() {
        ChangeEvent<Integer> event = new ChangeEvent<Integer>(1, 2);
        assertEquals(Integer.valueOf(1), event.getOldValue());
        assertEquals(Integer.valueOf(2), event.getNewValue());

        assertTrue(event.toString().startsWith("ChangeEvent"));

        assertEquals(event, event);
        assertEquals(new ChangeEvent<Integer>(1, 2), event);
        assertNotEquals(new ChangeEvent<Integer>(2, 3), event);
        assertNotEquals(new Object(), event);
        assertEquals(33, event.hashCode());
    }
}