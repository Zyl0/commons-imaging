/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.imaging.formats.psd.dataparsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class DataParserIndexedTest{

  @Test
  public void testFailsToCreateDataParserIndexedThrowsArrayIndexOutOfBoundsException() {
      final byte[] byteArray = new byte[24];
      try {
        new DataParserIndexed(byteArray);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      } catch (final ArrayIndexOutOfBoundsException e) {
         assertTrue(e.getMessage().contains("256"));
         assertEquals(DataParserIndexed.class.getName(), e.getStackTrace()[0].getClassName());
      }
  }

}