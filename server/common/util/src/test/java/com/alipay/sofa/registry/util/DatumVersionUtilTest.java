/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.registry.util;

import org.junit.Assert;
import org.junit.Test;

public class DatumVersionUtilTest {

  @Test
  public void testNextId() {
    long timestamp = System.currentTimeMillis();
    long epoch = DatumVersionUtil.nextId();
    long ts = DatumVersionUtil.getRealTimestamp(epoch);
    Assert.assertTrue(ts >= timestamp);
    Assert.assertTrue(ts <= System.currentTimeMillis());
  }

  @Test
  public void testUnit() {
    long timestamp = System.currentTimeMillis();
    long millis = DatumVersionUtil.untilNextMillis(timestamp + 100);
    Assert.assertTrue(millis >= timestamp + 100);
    Assert.assertTrue(millis <= System.currentTimeMillis());
  }
}