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
package org.apache.commons.imaging.bytesource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.commons.imaging.ImagingException;

class ByteSourceArray extends ByteSource {

    private final byte[] bytes;

    ByteSourceArray(final byte[] bytes, final String fileName) {
        super(fileName);
        this.bytes = bytes;
    }

    @Override
    public byte[] getByteArray(final long from, final int length) throws ImagingException {
        int start;
        try {
            start = Math.toIntExact(from);
        } catch (final ArithmeticException e) {
            throw new ImagingException(e);
        }
        // We include a separate check for int overflow.
        if ((start < 0) || (length < 0) || (start + length < 0)
                || (start + length > bytes.length)) {
            throw new ImagingException("Could not read block (block start: " + start
                    + ", block length: " + length + ", data length: "
                    + bytes.length + ").");
        }

        return Arrays.copyOfRange(bytes, start, start + length);
    }

    @Override
    public InputStream getInputStream() {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public long size() {
        return bytes.length;
    }

}
