/*
 * Copyright (C) 2020 Dremio
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
package org.projectnessie.api.params;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DiffParamsTest {

  @Test
  public void testBuilder() {
    DiffParams params = DiffParams.builder().fromRef("from").toRef("to").build();
    assertThat(params.getFromRef()).isEqualTo("from");
    assertThat(params.getToRef()).isEqualTo("to");
  }

  @Test
  public void testValidation() {
    assertThatThrownBy(() -> DiffParams.builder().fromRef("x").build())
        .isInstanceOf(NullPointerException.class)
        .hasMessage("toRef must be non-null");

    assertThatThrownBy(() -> DiffParams.builder().toRef("x").build())
        .isInstanceOf(NullPointerException.class)
        .hasMessage("fromRef must be non-null");
  }
}
