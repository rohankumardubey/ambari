#!/usr/bin/env python3
"""
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
"""

import stat
from unittest import TestCase
from resource_management.core.utils import attr_to_bitmask


class TestUtils(TestCase):
  def test_attr_to_bitmask(self):
    test_set = [
      ["+r", stat.S_IRUSR | stat.S_IRGRP | stat.S_IROTH, 0],
      ["u+w", stat.S_IWUSR, 0],
      ["uo+x", stat.S_IXUSR | stat.S_IXOTH, 0],
      ["-x", stat.S_IRUSR, stat.S_IXUSR | stat.S_IXOTH | stat.S_IRUSR],
      ["=x", stat.S_IXUSR | stat.S_IXOTH | stat.S_IXGRP, stat.S_IRUSR | stat.S_IRGRP],
    ]

    for test in test_set:
      test_pattern, expected, initial_val = test
      bitmask = attr_to_bitmask(test_pattern, initial_bitmask=initial_val)
      self.assertEqual(
        expected,
        bitmask,
        f'Test set "{test_pattern}" failed, expected: {expected} but got {bitmask}',
      )
