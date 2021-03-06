/* -*-mode:java; c-basic-offset:2; indent-tabs-mode:nil -*- */
/*
Copyright (c) 2012-2016 ymnk, JCraft,Inc. All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

  1. Redistributions of source code must retain the above copyright notice,
     this list of conditions and the following disclaimer.

  2. Redistributions in binary form must reproduce the above copyright 
     notice, this list of conditions and the following disclaimer in 
     the documentation and/or other materials provided with the distribution.

  3. The names of the authors may not be used to endorse or promote products
     derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JCRAFT,
INC. OR ANY CONTRIBUTORS TO THIS SOFTWARE BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.jcraft.jsch;

/**
 * Usually not to be used by applications.
 * A generic signature algorithm, with key and some state of
 * an ongoing signing or verification algorithm.
 * (Methods for providing the key are given in the subinterfaces
 * {@link SignatureDSA}, {@link SignatureECDSA}, {@link SignatureRSA},
 * which also have some more documentation.)
 * @since 0.1.49
 */
public interface Signature{
  /**
   * Initializes the signature object. (This can only do initialization
   * which do not depend on whether signing or checking is done.)
   */
  void init() throws Exception;
  /**
   * adds some more data to be signed/verified.
   * @param H the array containing the data to be signed/verified.
   */
  void update(byte[] H) throws Exception;
  /**
   * Verifies that the given signature is a correct signature.
   * @param sig an array containing the signature for the data
   *   given by {@link #update}.
   * @return true if the signature is correct,
   *    false if the signature is not correct.
   */
  boolean verify(byte[] sig) throws Exception;
  /**
   * Signs the data given so far to the {@link #update} method.
   * @return a signature for the data.
   */
  byte[] sign() throws Exception;
}
