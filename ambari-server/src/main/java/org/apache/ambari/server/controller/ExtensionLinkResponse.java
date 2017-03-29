/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.server.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.ambari.server.stack.Validable;

/**
 * An extension version is like a stack version but it contains custom services.  Linking an extension
 * version to the current stack version allows the cluster to install the custom services contained in
 * the extension version.
 */
public class ExtensionLinkResponse implements Validable {

  private String linkId;

  private String stackName;

  private String stackVersion;

  private String extensionName;

  private String extensionVersion;

  private boolean valid;

  private Set<String> errorSet = new HashSet<>();

  public ExtensionLinkResponse(String linkId, String stackName, String stackVersion, String extensionName,
                              String extensionVersion, boolean valid, Collection<String> errorSet) {

    setLinkId(linkId);
    setStackName(stackName);
    setStackVersion(stackVersion);
    setExtensionName(extensionName);
    setExtensionVersion(extensionVersion);
    setValid(valid);
    addErrors(errorSet);
  }

  public String getLinkId() {
    return linkId;
  }

  public void setLinkId(String linkId) {
    this.linkId = linkId;
  }

  public String getStackName() {
    return stackName;
  }

  public void setStackName(String stackName) {
    this.stackName = stackName;
  }

  public String getStackVersion() {
    return stackVersion;
  }

  public void setStackVersion(String stackVersion) {
    this.stackVersion = stackVersion;
  }

  public String getExtensionName() {
    return extensionName;
  }

  public void setExtensionName(String extensionName) {
    this.extensionName = extensionName;
  }

  public String getExtensionVersion() {
    return extensionVersion;
  }

  public void setExtensionVersion(String extensionVersion) {
    this.extensionVersion = extensionVersion;
  }

  @Override
  public boolean isValid() {
    return valid;
  }

  @Override
  public void setValid(boolean valid) {
    this.valid = valid;
  }

  @Override
  public void addError(String error) {
    errorSet.add(error);
  }

  @Override
  public Collection<String> getErrors() {
    return errorSet;
  }

  @Override
  public void addErrors(Collection<String> errors) {
    this.errorSet.addAll(errors);
  }
}
